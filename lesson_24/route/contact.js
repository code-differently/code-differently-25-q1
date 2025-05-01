const express = require("express");
const router = express.Router()

router.get("/" , (req, res) => {
    res.send("Contact List")
})

router.get("/new", (req, res) => {
    res.render("contact/new" , {firstName: "Test" })
})

router.post('/', (req, res) => {
    res.send('Create Contact')
})

router.get('/:id', (req, res) => {
    req.params.id
    res.send(`Get Contact with ID ${req.params.id}`)
})

module.exports = router