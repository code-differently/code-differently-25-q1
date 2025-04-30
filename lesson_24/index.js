
const express = require("express");
const app = express();
const port = 5000;
const cors = require("cors");
const path = require("path");

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(cors());  // Enable CORS globally

//Serve static files from the 'RMillerCDclone' directory
app.use(express.static(path.join(__dirname, 'RMillerCDclone')));

// Serve the contact form at the root
app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, 'RMillerCDclone'));  
});

// Handle form submission
app.post("/submit", (req, res) => {
    const { name, email, message } = req.body;

    // Log the form data to the console
    console.log("Received submission:");
    console.log(`Name: ${name}`);
    console.log(`Email: ${email}`);
    console.log(`Message: ${message}`);

    // Send a response back to the user
    res.send(`
        <h1>Thank you for your submission, ${name}!</h1>
        <p>We have received your message and will get back to you at ${email} soon.</p>
        <a href="/">Go back to the contact form</a>
    `);
});

// Start the server
app.listen(port, () => {
    console.log(`Listening at http://localhost:${port}`);  
});
