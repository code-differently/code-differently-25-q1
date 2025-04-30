const express = require('express')
const router = express.Router()
const contacts = [{ name: "Dylan", email: "123dylan@gmail.com"}, {name: "John", email: "123john@gmail.com"}]


router.get('/', (req, res) => {
    res.render("contact")
})

router.post("/", (req, res) => {

    const isValid = true
    if(isValid) {
        contacts.push({
            firstname: req.body.firstname,
            email: req.body.email

        })

        res.redirect(`/contact-us/${contacts.length - 1}`)
    } else {
        console.log("Error")
        res.render('contact-us', {firstname: req.body.firstname})
    }

    console.log(req.body.firstname)


})

router
    .route('/:id')
        .get((req, res) => {
            console.log(req.contact)
            res.render("newcontact", { contact: req.contact })
        }).put((req, res) => {
            res.send(`Set user with ID ${req.params.id}`)
        }).delete((req, res) => {
            res.send(`Goodbye user with ID ${req.params.id}`)
        })



router.param('id', (req, res, next, id) => {
    req.contact = contacts[id]
    next()
})

module.exports = router