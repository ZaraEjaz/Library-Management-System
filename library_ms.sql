-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 28, 2024 at 10:01 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(250) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`book_id`, `book_name`, `author`, `quantity`) VALUES
(1, 'The Great Gatsby', 'F. Scott Fitzgerald', 50),
(2, 'To Kill a Mockingbird', 'Harper Lee', 39),
(3, '1984', 'George Orwell', 59),
(4, 'Pride and Prejudice', 'Jane Austen', 55),
(5, 'The Catcher in the Rye', 'J.D. Salinger', 45),
(6, 'The Lord of the Rings', 'J.R.R. Tolkien', 65),
(7, 'Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', 70),
(8, 'The Hobbit', 'J.R.R. Tolkien', 55),
(9, 'Fahrenheit 451', 'Ray Bradbury', 35),
(10, 'Moby Dick', 'Herman Melville', 30),
(11, 'War and Peace', 'Leo Tolstoy', 25),
(12, 'The Odyssey', 'Homer', 40),
(13, 'The Divine Comedy', 'Dante Alighieri', 20),
(14, 'Brave New World', 'Aldous Huxley', 50),
(15, 'The Brothers Karamazov', 'Fyodor Dostoevsky', 30),
(16, 'Crime and Punishment', 'Fyodor Dostoevsky', 35),
(17, 'The Grapes of Wrath', 'John Steinbeck', 30),
(18, 'Jane Eyre', 'Charlotte Brontë', 40),
(19, 'Wuthering Heights', 'Emily Brontë', 30);

-- --------------------------------------------------------

--
-- Table structure for table `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(150) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issue_book_details`
--

INSERT INTO `issue_book_details` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(1, 2, 'The Great Gatsby', 2, 'Jane Smith', '2024-07-01', '2024-07-02', 'pending'),
(2, 3, 'To Kill a Mockingbird', 3, 'Alice Johnson', '2024-07-01', '2024-07-09', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `course` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `name`, `course`, `branch`) VALUES
(1, 'John', 'Computer Science', 'Engineering'),
(2, 'Jane Smith', 'Mechanical Engineering', 'Engineering'),
(3, 'Alice Johnson', 'Electrical Engineering', 'Engineering'),
(4, 'Robert Brown', 'Civil Engineering', 'Engineering'),
(5, 'Emily Davis', 'Biotechnology', 'Science'),
(6, 'Michael Wilson', 'Physics', 'Science'),
(7, 'Sarah Miller', 'Chemistry', 'Science'),
(8, 'David Taylor', 'Mathematics', 'Science'),
(9, 'Laura Anderson', 'Environmental Science', 'Science'),
(10, 'James Thomas', 'Biology', 'Science'),
(11, 'Patricia Jackson', 'Psychology', 'Engineering'),
(12, 'Christopher White', 'Sociology', 'Arts'),
(13, 'Elizabeth Harris', 'History', 'Arts'),
(14, 'Daniel Martin', 'Political Science', 'Arts'),
(15, 'Linda Thompson', 'English Literature', 'Arts'),
(16, 'Paul Garcia', 'Economics', 'Commerce'),
(17, 'Barbara Martinez', 'Accountancy', 'Commerce'),
(18, 'Mark Robinson', 'Business Administration', 'Commerce'),
(19, 'Nancy Clark', 'Marketing', 'Commerce'),
(20, 'Steven Rodriguez', 'Finance', 'Commerce'),
(21, 'Jessica Lewis', 'Law', 'Law'),
(22, 'George Lee', 'Criminal Justice', 'Law'),
(23, 'Susan Walker', 'International Relations', 'Law'),
(24, 'Charles Hall', 'Information Technology', 'Engineering'),
(25, 'Betty Young', 'Software Engineering', 'Engineering');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'Zara', 'zara123', 'zara@gmail.com', '1234567890'),
(2, 'Sara', 'sara123', 'sara@gmail.com', '0987654321'),
(3, 'Rehab', 'rehab', 'rehab@gmail.com', '1122334455'),
(4, 'usman', 'usman', 'usman@gmail.com', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_details`
--
ALTER TABLE `book_details`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
