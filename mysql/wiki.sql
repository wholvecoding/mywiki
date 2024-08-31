-- Create the users table
CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Create the categories table
CREATE TABLE IF NOT EXISTS categories (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Create the ebooks table
CREATE TABLE IF NOT EXISTS ebooks (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      title VARCHAR(255) NOT NULL,
    author VARCHAR(100),
    category_id INT,
    published_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
    );

-- Create the chapters table
CREATE TABLE IF NOT EXISTS chapters (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        ebook_id INT,
                                        chapter_number INT NOT NULL,
                                        title VARCHAR(255),
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (ebook_id) REFERENCES ebooks(id) ON DELETE CASCADE,
    UNIQUE(ebook_id, chapter_number)
    );


-- Insert some sample data into categories
INSERT INTO categories (name, description) VALUES
                                               ('Fiction', 'Fictional books'),
                                               ('Non-Fiction', 'Non-fictional books'),
                                               ('Science', 'Books related to science'),
                                               ('History', 'Books related to history');

-- Insert some sample data into users
INSERT INTO users (username, password, email) VALUES
                                                  ('admin', 'password_hash_here', 'admin@example.com'),
                                                  ('user1', 'password_hash_here', 'user1@example.com');

-- Sample data for ebooks
INSERT INTO ebooks (title, author, category_id, published_date) VALUES
                                                                    ('The Great Gatsby', 'F. Scott Fitzgerald', 1, '1925-04-10'),
                                                                    ('A Brief History of Time', 'Stephen Hawking', 3, '1988-03-01'),
                                                                    ('The Art of War', 'Sun Tzu', 4, '500-01-01');

-- Sample data for chapters
INSERT INTO chapters (ebook_id, chapter_number, title, content) VALUES
                                                                    (1, 1, 'Chapter 1', 'This is the content of Chapter 1 of The Great Gatsby.'),
                                                                    (1, 2, 'Chapter 2', 'This is the content of Chapter 2 of The Great Gatsby.'),
                                                                    (2, 1, 'Chapter 1', 'This is the content of Chapter 1 of A Brief History of Time.'),
                                                                    (3, 1, 'Chapter 1', 'This is the content of Chapter 1 of The Art of War.');