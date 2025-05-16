const express = require('express');
const router = express.Router(); // Create a router
const contacts = [{ name: "David Adenaike", email: "dadenaike251@gmail.com" }];

router.get("/", (req, res) => {
    res.render("contact"); // Send contact us
});

router.post("/", (req, res) => {
    const isValid = true; // Check if the form is valid
    if (isValid) {
        contacts.push({
            name: req.body.firstName, // Store name
            email: req.body.email,    // Store email
        });
        res.redirect(`/contact-us/${contacts.length - 1}`); // Send contact us
    } else {
        console.log("Error");
        res.render("contact", { firstname: req.body.firstName }); // Send contact us
    }
    console.log(req.body.firstName); // Log contact us
});

router
    .route("/:id")
    .get((req, res) => {
        console.log(req.contact); // Log contact us
        res.render("contact", { contact: req.contact }); // Send contact us
    })
    .put((req, res) => {
        res.send(`Set user with ID ${req.params.id}`); // Send contact us
    })
    .delete((req, res) => {
        res.send(`Thanks for contacting us ${req.params.id}`); // Send contact us
    });

router.param("id", (req, res, next, id) => {
    req.contact = contacts[id]; // Set contact us
    next();
});

module.exports = router; // Export the router