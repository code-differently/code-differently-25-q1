const express = require("express");
const app = express();
const port = 3000;
const cors = require("cors");
const path = require("path");

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(cors());  // Enable CORS globally

//Serve static files from the 'RMillerCDclone' directory
app.use(express.static(path.join(__dirname, 'public')));

// Handle form submission
app.post("/submit", (req, res) => {
    const { firstname, lastname, email, message } = req.body;

// Log the form data to the console
    console.log(`First Name: ${firstname}`);
    console.log(`Last Name: ${lastname}`);
    console.log(`Email: ${email}`);
    console.log(`Message: ${message}`);

// Send a response back to the user
    res.send(`
        <h1>Thank you for your submission, ${firstname}!</h1>
        <p>We have received your message and will get back to you at ${email} soon.</p>
        <a href="/">Go back to the contact form</a>
    `);
});

// Start the server
app.listen(port, () => {
    console.log(`Listening at http://localhost:${port}`);  
});