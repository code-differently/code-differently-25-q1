
const express = require("express");
const app = express();
const port = 5000;
const cors = require("cors");
const path = require("path");

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(cors());  // Enable CORS globally

//Serve static files from the 'RMillerCDclone' directory
app.use(express.static(path.join(__dirname, 'public')));

// Serve the contact form at the root
app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, 'public'));  
});

// Handle form submission
app.post("/submit", (req, res) => {
    const { name, email, message } = req.body;});

// Start the server
app.listen(port, () => {
    console.log(`Listening at http://localhost:${port}`);  
});
