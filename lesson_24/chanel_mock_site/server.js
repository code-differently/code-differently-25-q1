const express = require("express")
const morgan = require("morgan")
const path  = require("path")
var debug = require('debug')('myapp:server')


const app = express()

app.set("view engine", "ejs")

app.use(morgan("dev"))
app.use(express.static(path.join(__dirname, "public")))
app.use(express.urlencoded({ extended: true}))

const PORT = process.env.port || 3000

const userRouter = require('./routes/contact')

app.use('/contact', userRouter)

app.listen(PORT, () => {
    debug(`Server listening on http://localhost:${PORT}`)
})


