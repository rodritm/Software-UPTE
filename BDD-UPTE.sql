-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2017 a las 18:14:18
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `upte`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE `docente` (
  `iddocente` int(11) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `ape_pat` varchar(45) NOT NULL,
  `ape_mat` varchar(45) NOT NULL,
  `fechanac` date NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `celular` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idempleados` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `fechanc` date NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `celular` varchar(11) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `Tipo_empleado_idTipo_empleado` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`idempleados`, `nombres`, `apellido_paterno`, `apellido_materno`, `fechanc`, `direccion`, `celular`, `password`, `Tipo_empleado_idTipo_empleado`) VALUES
('9896776', 'Augusto', 'Lopez', 'Postigo', '1996-10-09', 'San Salvador', '76215591', '123', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `idestudiante` varchar(30) NOT NULL,
  `exp` varchar(4) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL COMMENT '		',
  `apellido_materno` varchar(45) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `Edad` varchar(11) DEFAULT NULL,
  `estado_civil` varchar(45) NOT NULL,
  `fechanc` varchar(10) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `zona` varchar(45) NOT NULL,
  `Ciudad` varchar(20) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `celular` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `per_contact` varchar(45) DEFAULT NULL,
  `per_tel` varchar(45) NOT NULL,
  `instruccion` varchar(45) NOT NULL,
  `profesion` varchar(45) DEFAULT NULL,
  `ocupacion` varchar(45) DEFAULT NULL,
  `actividad` varchar(45) DEFAULT NULL,
  `per_vive` varchar(45) DEFAULT NULL,
  `ingreso` varchar(45) NOT NULL,
  `info_upte` varchar(45) DEFAULT NULL,
  `problemas` varchar(45) DEFAULT NULL,
  `per_cel` varchar(11) DEFAULT NULL,
  `per_ape_pat` varchar(20) NOT NULL,
  `per_ape_mat` varchar(20) NOT NULL,
  `per_correo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idinscripcion` int(11) NOT NULL,
  `empleados_idempleados` varchar(45) NOT NULL,
  `estudiante_idestudiante` varchar(30) NOT NULL,
  `materia_has_docente_materia_idmateria` varchar(11) NOT NULL,
  `materia_has_docente_docente_iddocente` int(11) NOT NULL,
  `materia` varchar(45) DEFAULT NULL,
  `paralelo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idmateria` varchar(11) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `paralelo` varchar(2) NOT NULL,
  `hora` varchar(5) NOT NULL,
  `monto` float NOT NULL,
  `tiempo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia_has_docente`
--

CREATE TABLE `materia_has_docente` (
  `materia_idmateria` varchar(11) NOT NULL,
  `docente_iddocente` int(11) NOT NULL,
  `gestion` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibo`
--

CREATE TABLE `recibo` (
  `idrecibo` int(11) NOT NULL,
  `inscripcion_idinscripcion` int(10) NOT NULL,
  `fechan` varchar(10) NOT NULL,
  `anulado` tinyint(1) NOT NULL,
  `monto` float NOT NULL,
  `nit` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_empleado`
--

CREATE TABLE `tipo_empleado` (
  `idTipo_empleado` varchar(3) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_empleado`
--

INSERT INTO `tipo_empleado` (`idTipo_empleado`, `nombre`, `descripcion`) VALUES
('1', 'Adminnistrador', 'Acceso Total'),
('2', 'Empleado', 'Acceso Parcial'),
('3', 'Docente', 'Acceso Restringido');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`iddocente`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`idempleados`),
  ADD KEY `Tipo_empleado_idTipo_empleado` (`Tipo_empleado_idTipo_empleado`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`idestudiante`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idinscripcion`),
  ADD KEY `fk_inscripcion_empleados1_idx` (`empleados_idempleados`),
  ADD KEY `fk_inscripcion_estudiante1_idx` (`estudiante_idestudiante`),
  ADD KEY `fk_inscripcion_materia_has_docente1_idx` (`materia_has_docente_materia_idmateria`,`materia_has_docente_docente_iddocente`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idmateria`);

--
-- Indices de la tabla `materia_has_docente`
--
ALTER TABLE `materia_has_docente`
  ADD PRIMARY KEY (`materia_idmateria`,`docente_iddocente`),
  ADD KEY `fk_materia_has_docente_docente1_idx` (`docente_iddocente`),
  ADD KEY `fk_materia_has_docente_materia1_idx` (`materia_idmateria`);

--
-- Indices de la tabla `recibo`
--
ALTER TABLE `recibo`
  ADD PRIMARY KEY (`idrecibo`),
  ADD KEY `inscripcion_idinscripcion` (`inscripcion_idinscripcion`);

--
-- Indices de la tabla `tipo_empleado`
--
ALTER TABLE `tipo_empleado`
  ADD PRIMARY KEY (`idTipo_empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idinscripcion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `recibo`
--
ALTER TABLE `recibo`
  MODIFY `idrecibo` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`Tipo_empleado_idTipo_empleado`) REFERENCES `tipo_empleado` (`idTipo_empleado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `fk_inscripcion_empleados1` FOREIGN KEY (`empleados_idempleados`) REFERENCES `empleados` (`idempleados`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_inscripcion_estudiante1` FOREIGN KEY (`estudiante_idestudiante`) REFERENCES `estudiante` (`idestudiante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_inscripcion_materia_has_docente1` FOREIGN KEY (`materia_has_docente_materia_idmateria`,`materia_has_docente_docente_iddocente`) REFERENCES `materia_has_docente` (`materia_idmateria`, `docente_iddocente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `materia_has_docente`
--
ALTER TABLE `materia_has_docente`
  ADD CONSTRAINT `fk_materia_has_docente_docente1` FOREIGN KEY (`docente_iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_materia_has_docente_materia1` FOREIGN KEY (`materia_idmateria`) REFERENCES `materia` (`idmateria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `recibo`
--
ALTER TABLE `recibo`
  ADD CONSTRAINT `recibo_ibfk_1` FOREIGN KEY (`inscripcion_idinscripcion`) REFERENCES `inscripcion` (`idinscripcion`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
