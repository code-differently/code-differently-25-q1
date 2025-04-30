const express = require("express");
const router = express.Router()

router.get("/", (req, res) => {
    res.send("Contact")

})

router.get("/new", (req, res) => {
    res.send("New Contact Form")
})

router.post('/', (req, res) =>{
    res.send('Create Contact')
})

router
    .route("/:id")
    .get((req, res) => {
    console.log(req.contact)
    req.params.id
    res.send(`Get Contact with ID ${req.params.id}`)
})
     .put((req, res) => {
    req.params.id
    res.send(`Update Contact with ID ${req.params.id}`)
})
    .delete((req, res) => {
    req.params.id
    res.send(`Delete Contact with ID ${req.params.id}`)

})

const contact = [{ name: "Sally Hurt"}, { name: "LaKiesha Miller"}]
router.param("id", (req, res, next, id) => {
    console.log(id)
    req.contact = contact[id]
    next()
})

module.exports = router