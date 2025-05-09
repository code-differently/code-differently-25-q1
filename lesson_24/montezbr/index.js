const express = require('express');
const app = express()

app.use(express.static('public'))
app.set('view engine', 'ejs')
app.use(express.urlencoded({ extended: true }))

app.get('/', (req, res) => {
    console.log('Here')
    res.render('index')
})

app.post('/contact-form', (req, res) => {
    const { firstname, email, message } = req.body;
    res.send(`<h1>Thank you ${firstname} for your message: ${message}. We will contact you at ${email}</h1>`);
});

app.listen(3000, () => {
    console.log('Server is running on port 3000')
})

