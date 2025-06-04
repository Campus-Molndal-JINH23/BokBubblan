# BokBubblan 📚
*Swedish E-commerce Bookstore Platform*

A full-stack web application for an online bookstore built with Spring Boot and MongoDB. BokBubblan (Swedish for "Book Bubble") demonstrates modern web development practices with a complete e-commerce workflow, user management, and digital lending capabilities.

## 🌟 Project Highlights

- **Full-stack Spring Boot application** with MVC architecture
- **MongoDB integration** with Spring Data
- **Responsive web design** using Bootstrap and custom CSS
- **E-commerce functionality** including cart management and checkout
- **User authentication and authorization** system
- **Digital book lending** feature (24-hour loans)
- **Advanced search and filtering** capabilities
- **Review system** for books
- **Internationalization** (Swedish language interface)

## 🛠️ Technology Stack

### Backend
- **Java 17+** with Spring Boot
- **Spring Web MVC** - RESTful controllers and web layer
- **Spring Data MongoDB** - Database abstraction layer
- **Thymeleaf** - Server-side template engine
- **Lombok** - Boilerplate code reduction
- **Maven** - Dependency management and build tool

### Frontend
- **HTML5/CSS3** with responsive design
- **Bootstrap 5** - UI component framework
- **jQuery** - Dynamic content and AJAX interactions
- **Font Awesome & Bootstrap Icons** - Icon libraries
- **Thymeleaf templates** - Server-side rendering

### Database
- **MongoDB** - NoSQL document database
- **MongoDB Atlas** - Cloud database hosting

## 🏗️ Architecture Overview

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Frontend      │    │    Backend      │    │    Database     │
│                 │    │                 │    │                 │
│ • Thymeleaf     │◄──►│ • Spring Boot   │◄──►│ • MongoDB       │
│ • Bootstrap     │    │ • REST APIs     │    │ • Collections:  │
│ • jQuery        │    │ • MVC Pattern   │    │   - Books       │
│ • Custom CSS    │    │ • Services      │    │   - Users       │
└─────────────────┘    └─────────────────┘    │   - Cart        │
                                              │   - Reviews     │
                                              └─────────────────┘
```

## 🚀 Key Features

### 📖 Book Management
- **Product Catalog**: Comprehensive book listing with search functionality
- **Categories**: 
  - *Signerade förstautgåvor* (Signed First Editions)
  - *Sällsynta fantasyserier* (Rare Fantasy Series) 
  - *Interaktiva barnböcker* (Interactive Children's Books)
- **Advanced Filtering**: Price-based sorting (ascending/descending)
- **Search System**: Title-based book discovery

### 🛒 E-commerce Features
- **Shopping Cart**: Add/remove items, quantity management
- **Checkout Process**: Multi-step purchase flow
- **Payment Integration**: Multiple payment options
  - Credit Card (0 kr fee)
  - Swish (0 kr fee) - *Popular Swedish mobile payment*
  - Klarna (19 kr fee) - *Buy now, pay later service*
- **Order Management**: Confirmation and tracking system
- **Shipping**: Standard delivery (75 SEK, 2-3 business days)

### 👥 User Management
- **Authentication System**: Registration and login functionality
- **User Profiles**: Personal account management
- **Session Management**: Shopping cart persistence
- **Review System**: Book rating and feedback (1-5 stars)

### 📱 Digital Services
- **24-Hour Digital Lending**: Temporary book access via email
- **Responsive Design**: Mobile-first approach
- **Internationalization**: Swedish language support

## 🗂️ Project Structure

```
src/main/
├── java/se/samer/bokbubblan/
│   ├── BokBubblanApplication.java          # Main Spring Boot application
│   ├── config/
│   │   └── AppConfig.java                  # Application configuration
│   ├── controller/                         # REST Controllers
│   │   ├── ProductController.java          # Product management
│   │   ├── CartController.java             # Shopping cart operations
│   │   ├── AuthController.java             # User authentication
│   │   ├── CheckoutController.java         # Purchase workflow
│   │   └── ...
│   ├── service/                           # Business Logic Layer
│   │   ├── ProductService.java            # Product operations
│   │   ├── CartService.java               # Cart management
│   │   ├── UserService.java               # User operations
│   │   └── ...
│   ├── repository/                        # Data Access Layer
│   │   ├── ProductRepository.java         # Product data access
│   │   ├── UserRepository.java            # User data access
│   │   └── ...
│   ├── model/                            # Entity Classes
│   │   ├── Product.java                  # Book/Product entity
│   │   ├── User.java                     # User entity
│   │   ├── Cart.java                     # Shopping cart entity
│   │   └── ...
│   └── filter/                           # Utility Classes
│       ├── ProductFilter.java            # Product filtering logic
│       └── ProductSearch.java            # Search functionality
└── resources/
    ├── templates/                        # Thymeleaf Templates
    │   ├── index.html                    # Homepage
    │   ├── products.html                 # Product catalog
    │   ├── cart.html                     # Shopping cart
    │   ├── checkout.html                 # Checkout process
    │   └── ...
    ├── static/                          # Static Resources
    │   ├── css/
    │   │   ├── custom-style.css         # Custom styling
    │   │   └── simple-style.css         # Utility styles
    │   ├── js/
    │   │   └── app.js                   # Frontend JavaScript
    │   └── img/                         # Images and assets
    └── application.properties           # Application configuration
```

## 🗄️ Database Schema

### Collections Overview
- **Bokbubblan**: Product/book information
- **Users**: User account data
- **Cart**: Shopping cart sessions
- **Review**: Book reviews and ratings
- **user_profile**: Extended user information

### Sample Data Models

```json
// Product/Book Document
{
  "_id": "66261beadfc2d4c6579659e3",
  "title": "The Witcher",
  "author": "Andrzej Sapkowski", 
  "year": 1993,
  "category": "Sällsynta fantasyserier",
  "price": 850.0,
  "description": "En serie om en monsterjägare...",
  "itemNumber": "SFS001"
}

// User Document  
{
  "_id": "user123",
  "username": "bookLover",
  "email": "user@example.com",
  "password": "hashedPassword",
  "enabled": true
}
```

## 🚀 Getting Started

### Prerequisites
- **Java 17+** installed
- **Maven 3.6+** for dependency management
- **MongoDB** instance (local or cloud)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

### Installation & Setup

1. **Clone the repository**
```bash
git clone [repository-url]
cd BokBubblan
```

2. **Configure Database**
Update `src/main/resources/application.properties`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/bokbubblan
# OR for MongoDB Atlas:
# spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/bokbubblan
```

3. **Install Dependencies**
```bash
mvn clean install
```

4. **Run the Application**
```bash
mvn spring-boot:run
```

5. **Access the Application**
- Open browser to `http://localhost:8080`
- Default port: 8080

### Sample User Journey
1. **Browse Books**: Visit homepage and explore categories
2. **Search**: Use search functionality to find specific titles
3. **Add to Cart**: Select books and add to shopping cart
4. **Register/Login**: Create account or sign in
5. **Checkout**: Complete purchase with preferred payment method
6. **Digital Lending**: Option to borrow books for 24 hours

## 🧪 Testing

The project includes comprehensive test coverage:
- **Controller Tests**: API endpoint validation
- **Service Tests**: Business logic verification  
- **Integration Tests**: End-to-end workflow testing

Run tests with:
```bash
mvn test
```

## 🔧 Configuration

### Key Configuration Files
- `application.properties`: Database and server configuration
- `AppConfig.java`: Bean definitions and MongoDB setup
- `custom-style.css`: Swedish design theme and responsive layout

### Environment Variables
For production deployment, consider using environment variables:
```bash
MONGODB_URI=mongodb+srv://...
SERVER_PORT=8080
```

## 🌍 Internationalization Notes

**Swedish Language Features:**
- All user interfaces in Swedish
- Swedish payment methods (Swish)
- Swedish currency (SEK/kr)
- Local business practices (Klarna integration)

**Key Swedish Terms:**
- *Böcker* = Books
- *Kundvagn* = Shopping Cart  
- *Kassa* = Checkout
- *Signerade förstautgåvor* = Signed First Editions
- *Sällsynta fantasyserier* = Rare Fantasy Series
- *Interaktiva barnböcker* = Interactive Children's Books

## 🎯 Learning Outcomes & Technical Skills Demonstrated

This project showcases proficiency in:

- **Backend Development**: Spring Boot ecosystem, RESTful API design
- **Database Management**: MongoDB integration, data modeling
- **Frontend Development**: Responsive design, JavaScript/jQuery
- **Software Architecture**: MVC pattern, separation of concerns
- **E-commerce Logic**: Cart management, payment processing, order workflow
- **User Experience**: Intuitive Swedish-language interface
- **Code Organization**: Clean code principles, proper package structure
- **Testing**: Unit and integration testing strategies

## 📄 License

This project is for educational and portfolio demonstration purposes.

---

**Note for Recruiters**: This project demonstrates full-stack development capabilities with modern Java technologies, database integration, and real-world e-commerce functionality. The Swedish language interface shows cultural adaptability and attention to user experience in international contexts.
