const express = require('express');
const router = express.Router(); // Create a router
const contacts = [{ name: "David Adenaike", email: "dadenaike251@gmail.com"}]

router.get("/", (req, res) => {
    res.render("contact"); // Send contact us
});

// router.get("/new", (req, res) => {
//     res.send("Contact Us"); // Send contact us new
// });

// router.get('/new/:id', (req, res) => {
//     res.send(`Contact Us ${req.params.id}`); // Send contact us with id
// });

router.post("/", (req, res) => {
    const isValid = true; // Check if the form is valid
    if (isValid) {
        contacts.push({
            firstName: req.body.firstName,
            email: req.body.email,
        });
        res.redirect('/contact-us/${contacts.length - 1}'); // Send contact us
    } else {
        console.log("Error")
        res.render('contact-us', {firstname: req.body.firstname}); // Send contact us
    }
    console.log(req.body.firstname) // Log contact us
});

router
    .route("/:id")
    .get((req, res) => {
        console.log(req.contactUs); // Log contact us
        res.render("contact", {contact: req.contact}); // Send contact us
    })
    .put((req, res) => {
        res.send('Set user with ID ${req.params.id}'); // Send contact us
    })
    .delete((req, res) => {
        res.send('Thanks for contacting us ${req.params.id}'); // Send contact us
    })



router.param("id",(req, res, next, id) => {
    req.contact = contacts[id] // Set contact us
    next();
})

module.exports = router; // Export the router