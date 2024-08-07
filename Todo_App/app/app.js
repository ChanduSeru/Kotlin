const { MongoClient, ObjectId } = require('mongodb');
const readline = require('readline-sync');

const url = 'mongodb://localhost:27017';
const dbname = 'crud';
let db, collection;
let loggedInUser = null;

async function connect() {
    const client = new MongoClient(url);
    try {
        await client.connect();
        console.log("Connected to server");
        db = client.db(dbname);
        collection = db.collection("crudcollection");
    } catch (err) {
        console.error(err);
        process.exit(1);
    }
}

async function createUser() {
    const username = readline.question("Enter username: ");
    const password = readline.question("Enter password: ");
    const result = await db.collection("users").insertOne({ username, password });
    console.log('User created with id ', result.insertedId);
}

async function login() {
    const username = readline.question("Enter username: ");
    const password = readline.question("Enter password: ");
    const user = await db.collection("users").findOne({ username, password });
    if (user) {
        loggedInUser = user;
        console.log("Login successful");
    } else {
        console.log("Invalid username or password");
    }
}

function isAuthenticated() {
    return loggedInUser !== null;
}

async function create() {
    if (!isAuthenticated()) {
        console.log("You must be logged in to perform this operation.");
        return;
    }
    const name = readline.question("Enter name: ");
    const age = readline.questionInt("Enter age: ");
    const city = readline.question("Enter city: ");
    const result = await collection.insertOne({ name, age, city });
    console.log('Document inserted with id ', result.insertedId);
}

async function get() {
    if (!isAuthenticated()) {
        console.log("You must be logged in to perform this operation.");
        return;
    }
    const documents = await collection.find().toArray();
    console.log('Documents: ', documents);
}

async function update() {
    if (!isAuthenticated()) {
        console.log("You must be logged in to perform this operation.");
        return;
    }
    const id = readline.question("Enter id: ");
    const newName = readline.question("Enter name: ");
    const newAge = readline.questionInt("Enter age: ");
    const newCity = readline.question("Enter city: ");
    const result = await collection.updateOne(
        { _id: new ObjectId(id) },
        { $set: { name: newName, age: newAge, city: newCity } }
    );
    console.log('Matched count:', result.matchedCount);
    console.log('Modified count:', result.modifiedCount);
}

async function deleteDocument() {
    if (!isAuthenticated()) {
        console.log("You must be logged in to perform this operation.");
        return;
    }
    const id = readline.question("Enter id to delete: ");
    const result = await collection.deleteOne({ _id: new ObjectId(id) });
    console.log('Deleted count:', result.deletedCount);
}

async function menu() {
    while (true) {
        console.log('\nMenu');
        console.log('1. Create User');
        console.log('2. Login');
        console.log('3. Create Document');
        console.log('4. Get Documents');
        console.log('5. Update Document');
        console.log('6. Delete Document');
        console.log('7. Exit');
        const choice = readline.question('Enter your choice: ');
        switch (choice) {
            case '1':
                await createUser();
                break;
            case '2':
                await login();
                break;
            case '3':
                await create();
                break;
            case '4':
                await get();
                break;
            case '5':
                await update();
                break;
            case '6':
                await deleteDocument();
                break;
            case '7':
                console.log('Exiting...');
                process.exit(0);
            default:
                console.log('Invalid choice');
        }
    }
}

(async () => {
    await connect();
    menu();
})();