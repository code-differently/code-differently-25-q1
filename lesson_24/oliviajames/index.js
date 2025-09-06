const express = require('express')
const path = require('path')
const app = express()

app.use(express.static('public'))
app.use(express.urlencoded({ extended: true }))

app.get('/contact', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'contact.html'));
})

app.post('/contact', async(req, res) => {
    const {name, email, message} = req.body;
    res.send(`we recieved the following credentials . name: ${name} email: ${email} message: ${message}`)
})

app.listen(3000, () => {
    console.log('Server is running on port 3000')
})
