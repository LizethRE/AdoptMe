-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-06-2019 a las 14:53:51
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dali`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adopcion`
--

CREATE TABLE `adopcion` (
  `id` int(11) NOT NULL,
  `idusuario` varchar(100) NOT NULL,
  `idanimal` int(11) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `foto` varchar(300) DEFAULT NULL,
  `ubicacion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `adopcion`
--

INSERT INTO `adopcion` (`id`, `idusuario`, `idanimal`, `descripcion`, `foto`, `ubicacion`) VALUES
(1, 'desoft@gmail.com', 1, 'Por motivo de viaje doy a mi perro en adopcion.', '../publicaciones/adopcion/f22290c9dd14baf8f73a816ab4ab19bffe1d9243.jpg', 'Mi casa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal`
--

CREATE TABLE `animal` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `idtipoanimal` int(11) NOT NULL,
  `edad` varchar(10) NOT NULL,
  `idgenero` int(11) NOT NULL,
  `idtamanio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `animal`
--

INSERT INTO `animal` (`id`, `nombre`, `idtipoanimal`, `edad`, `idgenero`, `idtamanio`) VALUES
(1, 'Coffe', 1, '5 Meses', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `callejero`
--

CREATE TABLE `callejero` (
  `id` int(11) NOT NULL,
  `idusuario` varchar(100) NOT NULL,
  `descripcion` varchar(300) CHARACTER SET utf16 NOT NULL,
  `foto` varchar(300) DEFAULT NULL,
  `nombrecontacto` varchar(100) NOT NULL,
  `telefonocontacto` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `callejero`
--

INSERT INTO `callejero` (`id`, `idusuario`, `descripcion`, `foto`, `nombrecontacto`, `telefonocontacto`) VALUES
(1, 'dana@gmail.com', 'Esta hermosa gata está buscando un hogar adoptivo. \r\nSi estás interesado/a en hacerla parte de tu familia por favor escribe o llamar.', '../publicaciones/callejero/3e182b1ea9376483a38614d916a0b666ef531b6d.jpg', 'Maria', '3145301464'),
(2, 'desoft@gmail.com', 'Gato en condición de calle. Urgente de unas manos cariñosas que le salven la vida. ', '../publicaciones/callejero/cc042292474fdb5897142258e697ba0f8b94115b.jpg', 'Andrea', '3125944671');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id`, `descripcion`) VALUES
(1, 'Hembra'),
(2, 'Macho');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tamanio`
--

CREATE TABLE `tamanio` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tamanio`
--

INSERT INTO `tamanio` (`id`, `descripcion`) VALUES
(1, 'Pequeño'),
(2, 'Mediano'),
(3, 'Grande');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoanimal`
--

CREATE TABLE `tipoanimal` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipoanimal`
--

INSERT INTO `tipoanimal` (`id`, `descripcion`) VALUES
(1, 'Perro'),
(2, 'Gato');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombre` varchar(100) NOT NULL,
  `foto` varchar(300) DEFAULT NULL,
  `telefono` varchar(10) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombre`, `foto`, `telefono`, `correo`, `contraseña`) VALUES
('Dana', '/assets/paper_img/banks.jpg', '3145555555', 'dana@gmail.com', 'dana'),
('DeSoft', '/assets/paper_img/placeholder.jpg', '3145555555', 'desoft@gmail.com', 'desoft'),
('Eduardo Cruces', '/assets/paper_img/chet_faker_1.jpg', '3145555555', 'eduardo@gmail.com', 'eduardo'),
('Thaliana', '/assets/paper_img/placeholder.jpg', '3145555555', 'thali@gmail.com', 'thali'),
('Yorgi', '/assets/paper_img/chet_faker_2.jpg', '3145555555', 'yorgi@gmail.com', 'yorgi');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `adopcion`
--
ALTER TABLE `adopcion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idusuario` (`idusuario`),
  ADD KEY `idanimal` (`idanimal`);

--
-- Indices de la tabla `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idtipoanimal` (`idtipoanimal`),
  ADD KEY `idgenero` (`idgenero`),
  ADD KEY `idtamanio` (`idtamanio`);

--
-- Indices de la tabla `callejero`
--
ALTER TABLE `callejero`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idusuario` (`idusuario`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tamanio`
--
ALTER TABLE `tamanio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipoanimal`
--
ALTER TABLE `tipoanimal`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `adopcion`
--
ALTER TABLE `adopcion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `animal`
--
ALTER TABLE `animal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `callejero`
--
ALTER TABLE `callejero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tamanio`
--
ALTER TABLE `tamanio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipoanimal`
--
ALTER TABLE `tipoanimal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `adopcion`
--
ALTER TABLE `adopcion`
  ADD CONSTRAINT `adopcion_ibfk_2` FOREIGN KEY (`idanimal`) REFERENCES `animal` (`id`),
  ADD CONSTRAINT `adopcion_ibfk_3` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`correo`);

--
-- Filtros para la tabla `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`idtamanio`) REFERENCES `tamanio` (`id`),
  ADD CONSTRAINT `animal_ibfk_2` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`id`),
  ADD CONSTRAINT `animal_ibfk_3` FOREIGN KEY (`idtipoanimal`) REFERENCES `tipoanimal` (`id`);

--
-- Filtros para la tabla `callejero`
--
ALTER TABLE `callejero`
  ADD CONSTRAINT `callejero_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`correo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
