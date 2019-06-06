-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2019 a las 02:50:44
-- Versión del servidor: 5.7.14
-- Versión de PHP: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `unimonito`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apuesta`
--

CREATE TABLE `apuesta` (
  `idapuesta` int(11) NOT NULL,
  `valor_maximo` int(11) NOT NULL,
  `valor_minimo` int(11) NOT NULL,
  `partido_idpartido` int(11) NOT NULL,
  `activo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apuesta`
--

INSERT INTO `apuesta` (`idapuesta`, `valor_maximo`, `valor_minimo`, `partido_idpartido`, `activo`) VALUES
(31, 50000, 10000, 41, 1),
(32, 50000, 10000, 42, 1),
(33, 50000, 10000, 43, 1),
(34, 50000, 10000, 44, 1),
(35, 50000, 10000, 45, 1),
(36, 50000, 10000, 46, 1),
(37, 50000, 10000, 49, 1),
(38, 50000, 10000, 50, 1),
(39, 50000, 10000, 51, 1),
(40, 50000, 10000, 52, 1),
(41, 50000, 10000, 53, 1),
(42, 50000, 10000, 54, 1),
(43, 50000, 10000, 55, 1),
(44, 50000, 10000, 56, 1),
(45, 50000, 10000, 57, 0),
(46, 50000, 10000, 58, 1),
(47, 50000, 10000, 59, 1),
(48, 50000, 10000, 0, 1),
(49, 50000, 10000, 0, 1),
(50, 50000, 10000, 0, 0),
(51, 50000, 10000, 0, 1),
(52, 50000, 10000, 0, 1),
(53, 50000, 10000, 64, 1),
(54, 50000, 10000, 65, 1),
(55, 50000, 10000, 66, 1),
(56, 50000, 10000, 67, 1),
(57, 50000, 10000, 68, 1),
(58, 50000, 10000, 69, 1),
(59, 50000, 10000, 70, 1),
(60, 50000, 10000, 71, 1),
(61, 50000, 10000, 72, 1),
(62, 50000, 10000, 73, 1),
(63, 50000, 10000, 74, 1),
(64, 50000, 10000, 75, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta`
--

CREATE TABLE `boleta` (
  `idboleta` int(11) NOT NULL,
  `valor` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `apuesta_idapuesta` int(11) DEFAULT NULL,
  `gano` int(11) NOT NULL,
  `rifa_idrifa` int(11) DEFAULT NULL,
  `marcador_apuesta` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deporte`
--

CREATE TABLE `deporte` (
  `iddeporte` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `deporte`
--

INSERT INTO `deporte` (`iddeporte`, `nombre`) VALUES
(1, 'futbol'),
(2, 'baloncesto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `idequipo` int(11) NOT NULL,
  `nombre_equipo` varchar(45) NOT NULL,
  `deporte_iddeporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`idequipo`, `nombre_equipo`, `deporte_iddeporte`) VALUES
(1, 'los primeros', 1),
(2, 'los segundos', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE `partido` (
  `idpartido` int(11) NOT NULL,
  `equipo_local` int(11) NOT NULL,
  `equipo_visitante` int(11) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `marcador` varchar(45) NOT NULL,
  `hora_inicio` varchar(45) NOT NULL,
  `hora_fin` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `partido`
--

INSERT INTO `partido` (`idpartido`, `equipo_local`, `equipo_visitante`, `fecha`, `marcador`, `hora_inicio`, `hora_fin`) VALUES
(24, 1, 2, '2019-03-24', '0-0', '10:00', '10:00'),
(25, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(26, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(27, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(28, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(29, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(30, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(31, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(32, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(33, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(34, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(35, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(36, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(37, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(38, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(39, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(40, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(41, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(42, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(43, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(44, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(45, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(46, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(47, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(48, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(49, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(50, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(51, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(52, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(53, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(54, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(55, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(56, 2, 1, '2019-03-24', '0-0', '10:00', '10:00'),
(57, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(58, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(59, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(60, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(61, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(62, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(63, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(64, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(65, 1, 2, '2019-03-24', '0-0', '10:00', '11:00'),
(66, 2, 1, '2019-03-26', '0-0', '09:00', '10:00'),
(67, 2, 1, '2019-03-26', '0-0', '09:00', '10:00'),
(68, 1, 2, '2019-03-27', '0-0', '10:00', '11:00'),
(69, 1, 2, '2019-03-24', '0-0', '10:00', '10:00'),
(70, 1, 2, '2019-03-24', '0-0', '10:00', '10:00'),
(71, 1, 2, '2019-03-24', '0-0', '10:00', '10:00'),
(72, 1, 2, '2019-03-24', '0-0', '10:00', '10:00'),
(73, 1, 2, '2019-03-24', '0-0', '10:00', '10:00'),
(74, 1, 2, '2019-03-24', '0-0', '10:00', '10:00'),
(75, 1, 2, '2019-03-24', '0-0', '10:00', '10:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rifa`
--

CREATE TABLE `rifa` (
  `idrifa` int(11) NOT NULL,
  `premio` varchar(45) CHARACTER SET big5 NOT NULL,
  `numero_boletas` int(11) NOT NULL,
  `hora_inicio` varchar(45) NOT NULL,
  `hora_fin` varchar(45) NOT NULL,
  `valor` int(11) NOT NULL,
  `activo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rifa`
--

INSERT INTO `rifa` (`idrifa`, `premio`, `numero_boletas`, `hora_inicio`, `hora_fin`, `valor`, `activo`) VALUES
(1, 'viaje', 10, '09:00', '10:00', 10000, 1),
(2, 'viaje', 10, '09:00', '10:00', 10000, 1),
(3, 'cerveza', 30, '10:00', '09:00', 5000, 1),
(4, 'cerveza', 30, '10:00', '09:00', 5000, 1),
(5, 'UN VIAJE', 20, '10:00', '11:00', 5000, 1),
(6, 'viaje', 10, '10:00', '11:00', 2000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idrol`, `nombre`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `identificacion` int(11) NOT NULL,
  `rol_idrol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombres`, `apellidos`, `identificacion`, `rol_idrol`) VALUES
(1, 'Karen', 'Rodriguez', 1234, 1),
(2, 'Usuario', 'prueba 1', 12, 2),
(3, 'USUARIO', 'PRUEBA', 9876, 2),
(4, 'USUARIO', 'PRUEBA', 9876, 2),
(5, 'USUARIO', 'PRUEBA', 9876, 2),
(6, 'USUARIO', 'PRUEBA', 9876, 2),
(7, 'USUARIO', 'PRUEBA', 9876, 2),
(8, 'USUARIO', 'PRUEBA', 9876, 2),
(9, 'USUARIO', 'PRUEBA', 9876, 2),
(10, 'USUARIO', 'PRUEBA', 9876, 2),
(11, 'OTRO', 'USUARIO', 87, 2),
(12, 'OTRO', 'USUARIO', 87, 2),
(13, 'prueba ', '2', 2222, 2),
(14, 'prueba ', '2', 2222, 2),
(15, 'prueba ', '2', 2222, 2),
(16, 'prueba ', '2', 2222, 2),
(17, 'Stefanie', 'Rodriguez', 765, 2),
(18, 'Nairo', 'Boom', 876, 2),
(19, 'Prueba ', 'tercera', 543, 2),
(20, 'Prueba ', 'tercera', 543, 2),
(21, 'USUARIO', 'PRUEBA 3', 34, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `apuesta`
--
ALTER TABLE `apuesta`
  ADD PRIMARY KEY (`idapuesta`);

--
-- Indices de la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD PRIMARY KEY (`idboleta`);

--
-- Indices de la tabla `deporte`
--
ALTER TABLE `deporte`
  ADD PRIMARY KEY (`iddeporte`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`idequipo`);

--
-- Indices de la tabla `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`idpartido`);

--
-- Indices de la tabla `rifa`
--
ALTER TABLE `rifa`
  ADD PRIMARY KEY (`idrifa`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `idusuarios_UNIQUE` (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apuesta`
--
ALTER TABLE `apuesta`
  MODIFY `idapuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT de la tabla `boleta`
--
ALTER TABLE `boleta`
  MODIFY `idboleta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `deporte`
--
ALTER TABLE `deporte`
  MODIFY `iddeporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `idequipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `partido`
--
ALTER TABLE `partido`
  MODIFY `idpartido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
--
-- AUTO_INCREMENT de la tabla `rifa`
--
ALTER TABLE `rifa`
  MODIFY `idrifa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idrol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
