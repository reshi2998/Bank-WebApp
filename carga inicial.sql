
USE `eif209_2001_p01` ;
INSERT INTO `eif209_2001_p01`.`moneda`
	(`nombre`, `descripcion`, `simbolo`, `tipo_cambio_compra`, `tipo_cambio_venta`)
	VALUES
		('CRC', 'Colón', '₡', 1.0, 1.0),
		('USD', 'Dólar EEUU', '$', 560.0, 570.0),
		('EUR', 'Euro', '€', 700.0, 720.0)
	;
    
INSERT INTO `eif209_2001_p01`.`tipo_cuenta`
	(`id_tipo_cuenta`, `descripcion`)
    VALUES
		(1, 'Cuenta corriente'),
		(2, 'Cuenta de ahorros'),
		(3, 'Cuenta especial')
	;

INSERT INTO `eif209_2001_p01`.`interes`
	(`cuenta_id_tipo`, `moneda_nombre`, `tasa_interes`)
    VALUES
		(1, 'CRC', 0.000),
		(2, 'CRC', 0.050),
		(3, 'CRC', 0.030),
		(1, 'USD', 0.000),
		(2, 'USD', 0.015),
		(3, 'USD', 0.007),
		(1, 'EUR', 0.000),
		(2, 'EUR', 0.020),
		(3, 'EUR', 0.012)
	;
    
SELECT * FROM `eif209_2001_p01`.`moneda`;
SELECT * FROM `eif209_2001_p01`.`tipo_cuenta`;
SELECT
	`interes`.`cuenta_id_tipo`,
    `interes`.`moneda_nombre`,
    `interes`.`tasa_interes` * 100.0 AS `tasa (%)`
	FROM `eif209_2001_p01`.`interes`;

/* Datos de prueba para usuario */
INSERT INTO `eif209_2001_p01`.`usuario` 
	(`id_usuario`, `clave_acceso`, `clave_vencida`, `rol`)
    VALUES
		('cajero', 'pass', 1, 1), 	/* Cajero */
        ('cliente', 'pass', 1, 0), /* Cliente */
        ('roy', 'pass', 1, 1), 	/* Cajero */
		('pepe', 'pass', 1, 0), /* Cliente */
		('jose', 'pass', 1, 0)	/* Cliente */
	;
    
/* Datos de prueba para cliente */
INSERT INTO `eif209_2001_p01`.`cliente` 
	(`id_cliente`, `usuario_id_usuario`, `apellidos`, `nombre`, `telefono`)
    VALUES
		('111111111', 'cajero', 'Luis', 'Khalo Pitt', '22000005'),
        ('000000000', 'cliente', 'Ana', 'Paez Wong', '25555455'),
        ('123456789', 'roy', 'Royner', 'Arias Chavez', '22334455'), 	
		('987654321', 'pepe', 'Pedro', 'Garita Herrera', '55667788'), 
		('012345678', 'jose', 'Jose', 'Castro Duarte', '77883399')	
	;
    
/* Datos de prueba para cuenta */
INSERT INTO `eif209_2001_p01`.`cuenta` 
	(`num_cuenta`, `tipo_cuenta_id_tipo_cuenta`, `cliente_id_cliente`, `moneda_nombre`, `fecha_creacion`, 
    `limite_transferencia_diaria`, `activa`,`saldo_inicial`, `fecha_ultima_aplicacion`, `saldo_final`)
    VALUES
		('11111111111111111', 1, '111111111', 'CRC', '2019-11-12', 2000000, 1, 0, '2020-04-23', 700000),
        ('00000000000000000', 2, '000000000', 'CRC', '2019-11-27', 1000000, 1, 0, '2020-04-25', 500000),
        ('11111110000000000', 2, '000000000', 'CRC', '2019-11-28', 1000000, 1, 0, '2020-04-21', 700000),
        ('11100000000000111', 1, '000000000', 'CRC', '2019-11-22', 1000000, 1, 0, '2020-04-21', 400000),
        ('19283746509372837', 3, '123456789', 'CRC', '2019-11-12', 2000000, 1, 0, '2020-04-23', 900000), 	
		('26371628374637829', 2, '987654321', 'CRC', '2020-01-04', 500000, 1, 0, '2020-04-23', 600000),
        ('26000044494637829', 1, '987654321', 'CRC', '2020-03-05', 500000, 1, 0, '2020-03-05', 100000),
		('90393948382293030', 1, '012345678', 'CRC', '2020-04-01', 1000000, 1, 0, '2020-04-04', 0)	
	;
    
/* Datos de prueba para movimiento */
INSERT INTO `eif209_2001_p01`.`movimiento` 
	(`id_movimiento`, `cuenta_num_cuenta`, `monto`, `fecha`, `aplicado`, `detalle`)
    VALUES
        (1, '11111111111111111', 50000, '2020-02-01', 1, 'Ahorros'), 	
		(2, '00000000000000000', 50000, '2020-02-01', 1, 'PS4'),
        (3, '00000000000000000', 20000, '2020-02-05', 1, 'PS4'),
        (4, '11111110000000000', 100000, '2020-02-05', 1, 'Cocina nueva'),
        (5, '11100000000000111', 30000, '2020-02-07', 1, 'Retiro'),
        (6, '11100000000000111', 70000, '2020-02-07', 1, 'Transf. Salario'),
        (7, '26371628374637829', 70000, '2020-02-07', 1, 'Ahorros'),
        (8, '26000044494637829', 1000000, '2020-02-07', 1, 'Arreglo carro')
	;
    
SELECT * FROM `eif209_2001_p01`.`usuario`;
SELECT * FROM `eif209_2001_p01`.`cliente`;
SELECT * FROM `eif209_2001_p01`.`cuenta`;
SELECT * FROM `eif209_2001_p01`.`movimiento`;

