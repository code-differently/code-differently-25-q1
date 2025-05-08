const express = require("express");
const router = express.Router()

router.get("/", (req, res) => {
    res.render("index");

})

router.post('/', (req, res) =>{
    const { name, email, message } = req.body;
    res.render('contact-submitted', { name, email, message });
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