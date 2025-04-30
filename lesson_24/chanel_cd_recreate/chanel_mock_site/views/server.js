const express = require('express')
const app = express()

app.set("views", 'ejs')

app.get('/', (req, res) => {
    console.log('Here')
    res.render("index", {text: "World" })
})

app.listen(3000)
