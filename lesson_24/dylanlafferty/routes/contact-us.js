const express = require('express')
const router = express.Router()

router.get('/', (req, res) => {
    res.render("contact.ejs")
})

router.get('/new', (req, res) => {
    res.send("Thank you for submitting your contact info!")
})

router.post("/", (req, res) => {
    res.render("contact")
})

module.exports = router