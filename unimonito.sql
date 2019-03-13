-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-03-2019 a las 18:17:26
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
  `idApuesta` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `valor_apuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta`
--

CREATE TABLE `boleta` (
  `idBoleta` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `Tipo_Boleta_idTipo_Boleta` int(11) NOT NULL,
  `Boleteria_idBoleteria` int(11) NOT NULL,
  `Boleteria_Apuesta_idApuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleteria`
--

CREATE TABLE `boleteria` (
  `idBoleteria` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `Apuesta_idApuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catalogo_rifa`
--

CREATE TABLE `catalogo_rifa` (
  `idCatalogo_Rifa` int(11) NOT NULL,
  `nombre_evento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deporte`
--

CREATE TABLE `deporte` (
  `idDeporte` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `Torneo_idTorneo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `idEquipo` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `Deporte_idDeporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `idJugador` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `edad` int(99) DEFAULT NULL,
  `Equipo_idEquipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcador`
--

CREATE TABLE `marcador` (
  `idMarcador` int(11) NOT NULL,
  `marcador_local` int(11) DEFAULT NULL,
  `marcador_visitante` int(11) DEFAULT NULL,
  `Apuesta_idApuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participante`
--

CREATE TABLE `participante` (
  `idParticipante` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `Apuesta_idApuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE `partido` (
  `idPartido` int(11) NOT NULL,
  `dia` date DEFAULT NULL,
  `hora_inicio` datetime DEFAULT NULL,
  `hora_fin` datetime DEFAULT NULL,
  `Torneo_idTorneo` int(11) NOT NULL,
  `Apuesta_idApuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premio`
--

CREATE TABLE `premio` (
  `idPremio` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `valor_premio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rifa`
--

CREATE TABLE `rifa` (
  `idRifa` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `Boleteria_idBoleteria` int(11) NOT NULL,
  `Boleteria_Apuesta_idApuesta` int(11) NOT NULL,
  `Premio_idPremio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rifa_has_catalogo_rifa`
--

CREATE TABLE `rifa_has_catalogo_rifa` (
  `Rifa_idRifa` int(11) NOT NULL,
  `Rifa_Boleteria_idBoleteria` int(11) NOT NULL,
  `Rifa_Boleteria_Apuesta_idApuesta` int(11) NOT NULL,
  `Rifa_Premio_idPremio` int(11) NOT NULL,
  `Catalogo_Rifa_idCatalogo_Rifa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_boleta`
--

CREATE TABLE `tipo_boleta` (
  `idTipo_Boleta` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE `torneo` (
  `idTorneo` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_boletas`
--

CREATE TABLE `venta_boletas` (
  `idVenta_Boletas` int(11) NOT NULL,
  `Venta_Boletascol` varchar(45) DEFAULT NULL,
  `Boleteria_idBoleteria` int(11) NOT NULL,
  `Boleteria_Apuesta_idApuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `apuesta`
--
ALTER TABLE `apuesta`
  ADD PRIMARY KEY (`idApuesta`);

--
-- Indices de la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD PRIMARY KEY (`idBoleta`,`nombre`,`Tipo_Boleta_idTipo_Boleta`,`Boleteria_idBoleteria`,`Boleteria_Apuesta_idApuesta`);

--
-- Indices de la tabla `boleteria`
--
ALTER TABLE `boleteria`
  ADD PRIMARY KEY (`idBoleteria`,`Apuesta_idApuesta`);

--
-- Indices de la tabla `catalogo_rifa`
--
ALTER TABLE `catalogo_rifa`
  ADD PRIMARY KEY (`idCatalogo_Rifa`);

--
-- Indices de la tabla `deporte`
--
ALTER TABLE `deporte`
  ADD PRIMARY KEY (`idDeporte`,`Torneo_idTorneo`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`idEquipo`,`Deporte_idDeporte`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`idJugador`);

--
-- Indices de la tabla `marcador`
--
ALTER TABLE `marcador`
  ADD PRIMARY KEY (`idMarcador`,`Apuesta_idApuesta`);

--
-- Indices de la tabla `participante`
--
ALTER TABLE `participante`
  ADD PRIMARY KEY (`idParticipante`,`Apuesta_idApuesta`);

--
-- Indices de la tabla `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`idPartido`,`Torneo_idTorneo`,`Apuesta_idApuesta`);

--
-- Indices de la tabla `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`idPremio`);

--
-- Indices de la tabla `rifa`
--
ALTER TABLE `rifa`
  ADD PRIMARY KEY (`idRifa`,`Boleteria_idBoleteria`,`Boleteria_Apuesta_idApuesta`,`Premio_idPremio`);

--
-- Indices de la tabla `rifa_has_catalogo_rifa`
--
ALTER TABLE `rifa_has_catalogo_rifa`
  ADD PRIMARY KEY (`Rifa_idRifa`,`Rifa_Boleteria_idBoleteria`,`Rifa_Boleteria_Apuesta_idApuesta`,`Rifa_Premio_idPremio`,`Catalogo_Rifa_idCatalogo_Rifa`);

--
-- Indices de la tabla `tipo_boleta`
--
ALTER TABLE `tipo_boleta`
  ADD PRIMARY KEY (`idTipo_Boleta`);

--
-- Indices de la tabla `torneo`
--
ALTER TABLE `torneo`
  ADD PRIMARY KEY (`idTorneo`);

--
-- Indices de la tabla `venta_boletas`
--
ALTER TABLE `venta_boletas`
  ADD PRIMARY KEY (`idVenta_Boletas`,`Boleteria_idBoleteria`,`Boleteria_Apuesta_idApuesta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apuesta`
--
ALTER TABLE `apuesta`
  MODIFY `idApuesta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `boleta`
--
ALTER TABLE `boleta`
  MODIFY `idBoleta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `boleteria`
--
ALTER TABLE `boleteria`
  MODIFY `idBoleteria` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `deporte`
--
ALTER TABLE `deporte`
  MODIFY `idDeporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `idEquipo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `idJugador` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `marcador`
--
ALTER TABLE `marcador`
  MODIFY `idMarcador` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `participante`
--
ALTER TABLE `participante`
  MODIFY `idParticipante` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `partido`
--
ALTER TABLE `partido`
  MODIFY `idPartido` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `premio`
--
ALTER TABLE `premio`
  MODIFY `idPremio` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `rifa`
--
ALTER TABLE `rifa`
  MODIFY `idRifa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_boleta`
--
ALTER TABLE `tipo_boleta`
  MODIFY `idTipo_Boleta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `torneo`
--
ALTER TABLE `torneo`
  MODIFY `idTorneo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
