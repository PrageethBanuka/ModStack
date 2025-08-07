# ModStack

ModStack is a modern component library and management system that helps developers organize, preview, and reuse UI components across their projects.

## Features

- 🎨 Component Library Management
- 🔍 Live Component Preview
- 🏷️ Component Categorization and Tagging
- 🔎 Search and Filter Components
- 📱 Responsive Design
- ⚛️ Built with React & Atomic Design
- 🎯 Spring Boot Backend
- 🌟 Modern UI with Tailwind CSS

## Project Structure

```
ModStack/
├── frontend/               # React frontend
│   ├── src/
│   │   ├── components/    # React components using Atomic Design
│   │   │   ├── atoms/     # Basic building blocks
│   │   │   ├── molecules/ # Simple component combinations
│   │   │   └── organisms/ # Complex UI components
│   │   ├── pages/        # Page components
│   │   └── api/          # API service layer
│   └── public/           # Static assets
└── backend/              # Spring Boot backend
    └── src/
        └── main/
            ├── java/     # Java source files
            └── resources/ # Application resources
```

## Getting Started

### Prerequisites

- Node.js (v16 or higher)
- Java 17 or higher
- Maven

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/ModStack.git
   cd ModStack
   ```

2. Install frontend dependencies:
   ```bash
   cd frontend
   npm install
   ```

3. Install backend dependencies:
   ```bash
   cd ../backend
   mvn install
   ```

### Running the Application

1. Start the backend server:
   ```bash
   cd backend
   mvn spring-boot:run
   ```

2. Start the frontend development server:
   ```bash
   cd frontend
   npm start
   ```

The application will be available at http://localhost:3000

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
