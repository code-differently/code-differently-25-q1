const express = require('express')
const morgan = require("morgan")
const path = require("path")
var debug = require('debug')('dylanlafferty:server')

const app = express()

app.set("view engine", "ejs")
app.set("views", path.join(__dirname, "views")); 

app.use(morgan("dev")) //Sets morgan middleware
app.use(express.static(path.join(__dirname,"public"))) //this will get the files from public
app.use(express.urlencoded({ extended: true }))

const PORT = process.env.PORT || 3000

//we can get put post delete or patch with app
//Route take in a request and a response req res
//send data res.send("Hi")

app.get('/', (req, res) => {
    console.log("here")
    //res.status(500).send("Error : 505")
    res.render("contact")
})

const contactRouter = require('./routes/contact-us') //calls for my router

app.use("/contact-us", contactRouter)

app.post("/", (req, res) => {
    res.render("")
})

app.listen(PORT, () => {
    debug(`Example app listening on port ${PORT}`)
})