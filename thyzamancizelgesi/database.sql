-- Veritabanını oluştur
CREATE DATABASE IF NOT EXISTS UcakZamanCizelgesiDB;
USE UcakZamanCizelgesiDB;

-- Uçak zaman çizelgesi tablosunu oluştur
CREATE TABLE IF NOT EXISTS UcakZamanCizelgesi (
    EventID INT AUTO_INCREMENT PRIMARY KEY,
    Label VARCHAR(255) NOT NULL,
    Time DATETIME NOT NULL
);

-- Örnek verileri ekle
INSERT INTO UcakZamanCizelgesi (Label, Time) VALUES
    ('Kalkış', '2023-12-01 08:00:00'),
    ('Yemek Servisi', '2023-12-01 12:00:00'),
    ('Varış', '2023-12-01 16:30:00');
