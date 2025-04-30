const express = require('express')
const morgan = require("morgan")
const path = require("path")
var debug = require('debug')('dylanlafferty:server')

const app = express()

app.set("view engine", "ejs")
app.set("views", path.join(__dirname, "views")); 

 //Sets morgan middleware
app.use(morgan("dev"))

//this will get the files from public
app.use(express.static(path.join(__dirname,"public"))) 
app.use(express.urlencoded({ extended: true }))

const PORT = process.env.PORT || 3000

//we can get put post delete or patch with app
//Route take in a request and a response req res
//send data res.send("Hi")

app.get('/', (req, res) => {
    console.log("here")
    res.render("contact")
})

const contactRouter = require('./routes/contact-us')
 
app.use("/contact-us", contactRouter)

app.post("/", (req, res) => {
    res.render("")
})

app.listen(PORT, () => {
    debug(`Example app listening on port ${PORT}`)
})