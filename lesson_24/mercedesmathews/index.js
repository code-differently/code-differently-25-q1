const express = require('express')
const app = express()

app.set('view engine', 'ejs')

app.use(express.static('public'));
app.use(express.urlencoded({extended: true}))

app.get('/', (req, res) => {
  res.render("index")
})

app.get('/contact', (req, res) => {
  res.render("contact")
})

app.post('/submit', (req, res) => {
  const { firstName, message } = req.body;
  res.send(`<h1>Thanks for reaching out, ${firstName}!</h1><p>We got your message: "${message}"</p>`);
});

app.listen(3000, () => {
  console.log('Server running on http://localhost:3000');
});