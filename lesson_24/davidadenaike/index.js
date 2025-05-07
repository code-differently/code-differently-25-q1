const express = require("express"); // Get express
const morgan = require("morgan"); // Get morgan
const path = require("path"); // Get path
var debug = require('debug')('myapp:server'); // Get debug logger
 
const app = express(); // Create express app
 
app.use(morgan("dev")); // Setup morgan middleware
app.use(express.static(path.join(__dirname, "public"))); // Setup static files
app.use(express.urlencoded({ extended: true })); // Setup urlencoded middleware
app.use(express.json()); // Setup json middleware
app.set("view engine", "ejs"); // Setup view engine

app.get("/", (req, res) => { 
    console.log("Here")
    res.render("contact") // Render index.ejs
    })

const contactUsRouter = require("./routes/contact-us"); // Get contact us router

app.use("/contact-us", contactUsRouter); // Setup contact us router 
 
const PORT = process.env.PORT || 3000; // Setup port
 
// Start the server
app.listen(PORT, () => {
 debug(`Server listening on http://localhost:${PORT}`)
})