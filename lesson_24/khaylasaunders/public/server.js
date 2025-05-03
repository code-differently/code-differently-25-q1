const express = require('express');
 const bodyParser = require('body-parser');
 const path = require('path');
 
 const app = express();
 const PORT = 3000; // Change if needed
 
 // Middleware
 app.use(bodyParser.urlencoded({ extended: true }));
 app.use(express.static('.'));

//  app.use(express.static(path.join(__dirname, 'public')));
 
 // Routes
 app.get('/', (req, res) => {
   res.sendFile(path.join(__dirname, 'public/index.html'));
 });
 
 app.get('/contact', (req, res) => {
   res.sendFile(path.join(__dirname, 'public/contact.html'));
 });
 
 app.post('/submit-form', (req, res) => {
   const { name, email, message } = req.body;
   res.send(`
     <h1>Thank You!</h1>
     <p>Name: ${name}</p>
     <p>Email: ${email}</p>
     <p>Message: ${message}</p>
     <a href="/contact">Go Back</a>
   `);
 });
 
 // Start server
 app.listen(PORT, () => {
   console.log(`Server is running at http://localhost:${PORT}`);
 });