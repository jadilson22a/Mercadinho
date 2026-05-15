CREATE TABLE mercadoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(100) NOT NULL UNIQUE,
    preco DECIMAL(10,2) NOT NULL,
    quantidade DECIMAL(10,3) NOT NULL,

    unidade_medida ENUM(
        'UN',
        'KG',
        'G',
        'L',
        'ML',
        'M',
        'CM',
        'MM',
        'M2',
        'M3',
        'CX',
        'PCT',
        'FD',
        'DZ',
        'PAR'
    ) NOT NULL
);