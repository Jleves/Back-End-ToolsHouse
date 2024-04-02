package com.toolsToHome.PI;

import com.toolsToHome.PI.Model.*;
import com.toolsToHome.PI.Repository.*;
import com.toolsToHome.PI.Security.PasswordEncoder;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
@Builder
public class DataInitializer implements CommandLineRunner {

        private final HerramientaRepository herramientaRepository;
        private final CategoriaRepository categoriaRepository;
        private final UsuarioRepository usuarioRepository;
        private final CaracteristicaRepository caracteristicaRepository;
        private final PasswordEncoder passwordEncoder;
        private final ReservaRepository reservaRepository;
        private final ReseñaRepository reseñaRepository;

        //Repositorys
        @Autowired
        public DataInitializer(HerramientaRepository herramientaRepository, CategoriaRepository categoriaRepository, UsuarioRepository usuarioRepository, CaracteristicaRepository caracteristicaRepository, PasswordEncoder passwordEncoder, ReservaRepository reservaRepository, ReseñaRepository reseñaRepository) {
                this.herramientaRepository = herramientaRepository;
                this.categoriaRepository = categoriaRepository;
                this.usuarioRepository = usuarioRepository;
                this.caracteristicaRepository = caracteristicaRepository;
                this.passwordEncoder = passwordEncoder;
                this.reservaRepository = reservaRepository;
                this.reseñaRepository = reseñaRepository;
        }

        @Override
        public void run(String... args) {



                //Creacion De superAdmin

                Usuario superAdmin = Usuario.builder()
                        .email("superadmin@toolshouse.com")
                        .password(passwordEncoder.bCryptPasswordEncoder().encode("admin"))
                        .nombre("Super")
                        .apellido("Admin")
                        .ciudad("El Espacio Exterior")
                        .usuarioRole(UsuarioRole.SUPERADMIN)
                        .build();

                usuarioRepository.save(superAdmin);


                //Caracteristicas (5)


                Caracteristicas caracteristica1 = new Caracteristicas();
                caracteristica1.setTitulo("Resistente al agua");
                caracteristica1.setIcono("hammer");

                Caracteristicas caracteristica2 = new Caracteristicas();
                caracteristica2.setTitulo("Durabilidad");
                caracteristica2.setIcono("tree");

                Caracteristicas caracteristica3 = new Caracteristicas();
                caracteristica3.setTitulo("Portátil");
                caracteristica3.setIcono("user");

                Caracteristicas caracteristica4 = new Caracteristicas();
                caracteristica4.setTitulo("Facilidad de uso");
                caracteristica4.setIcono("ruler");

                Caracteristicas caracteristica5 = new Caracteristicas();
                caracteristica5.setTitulo("Alto rendimiento");
                caracteristica5.setIcono("pen");

                caracteristicaRepository.save(caracteristica1);
                caracteristicaRepository.save(caracteristica2);
                caracteristicaRepository.save(caracteristica3);
                caracteristicaRepository.save(caracteristica4);
                caracteristicaRepository.save(caracteristica5);





                //LLAVE INGLESA
                Herramienta herramienta1 = new Herramienta();
                Categoria categoria1=new Categoria();
                categoria1.setTitulo("Herreria");
                categoria1.setIcono("hammer");
                herramienta1.getCaracteristicas().add(caracteristica1);
                herramienta1.getCaracteristicas().add(caracteristica2);
                herramienta1.getCaracteristicas().add(caracteristica3);
                herramienta1.getCaracteristicas().add(caracteristica4);
                herramienta1.getCaracteristicas().add(caracteristica5);
                herramienta1.setCategoria(categoria1);
                herramienta1.setStock(10L);
                herramienta1.setPrecio(50L);
                herramienta1.setDisponibilidad(true);
                herramienta1.setNombre("Llave inglesa");






                herramienta1.setDescripcion("\n" +
                        "¡Presentamos la Llave Ajustable ProGrip, tu compañera confiable para enfrentar una amplia gama de tareas mecánicas con facilidad! Diseñada para durabilidad y precisión, esta versátil llave es un complemento indispensable para cualquier caja de herramientas.");
                //Imagenes Primera Herramienta
                Imagen imagenH1a = new Imagen();
                imagenH1a.setUrl("https://http2.mlstatic.com/D_NQ_NP_603946-MLA31563822315_072019-O.webp");
                imagenH1a.setHerramienta(herramienta1);
                Imagen imagenH1b = new Imagen();
                imagenH1b.setUrl("https://media.adeo.com/marketplace/MKP/85294392/01113b4aa9b94eeb4ecbd15c8625e14b.jpeg?width=3000&height=3000&format=jpg&quality=80&fit=bounds");
                imagenH1b.setHerramienta(herramienta1);
                Imagen imagenH1c = new Imagen();
                imagenH1c.setUrl("https://m.media-amazon.com/images/I/51Sxu-zygKL._AC_UF894,1000_QL80_.jpg");
                imagenH1c.setHerramienta(herramienta1);
                Imagen imagenH1d = new Imagen();
                imagenH1d.setUrl("https://http2.mlstatic.com/D_NQ_NP_890758-MCO46891203756_072021-O.webp");
                imagenH1d.setHerramienta(herramienta1);
                Imagen imagenH1e = new Imagen();
                imagenH1e.setUrl("https://http2.mlstatic.com/D_NQ_NP_605114-MLA44286542803_122020-O.webp");
                imagenH1e.setHerramienta(herramienta1);

                herramienta1.getImagenes().add(imagenH1a);
                herramienta1.getImagenes().add(imagenH1b);
                herramienta1.getImagenes().add(imagenH1c);
                herramienta1.getImagenes().add(imagenH1d);
                herramienta1.getImagenes().add(imagenH1e);

                categoriaRepository.save(categoria1);
                herramientaRepository.save(herramienta1);






                //PALA
                Herramienta herramienta2 = new Herramienta();
                Categoria categoria2=new Categoria();
                categoria2.setTitulo("Exterior");
                categoria2.setIcono("tree");
                herramienta2.getCaracteristicas().add(caracteristica1);
                herramienta2.getCaracteristicas().add(caracteristica2);
                herramienta2.getCaracteristicas().add(caracteristica3);
                herramienta2.getCaracteristicas().add(caracteristica4);
                herramienta2.getCaracteristicas().add(caracteristica5);
                herramienta2.setCategoria(categoria2);
                herramienta2.setStock(12L);
                herramienta2.setPrecio(50L);
                herramienta2.setDisponibilidad(true);
                herramienta2.setNombre("Pala");

                herramienta2.setDescripcion("\n" +
                        "¡Descubre la Pala de Jardinería ProDig, tu herramienta indispensable para trabajar la tierra con eficacia y comodidad! Esta pala robusta y confiable está diseñada para enfrentar una variedad de tareas de jardinería y paisajismo con facilidad.");
                //Imagenes Segunda Herramienta
                Imagen imagenH2a = new Imagen();
                imagenH2a.setUrl("https://http2.mlstatic.com/D_NQ_NP_785864-MLA31225252482_062019-O.webp");
                imagenH2a.setHerramienta(herramienta2);
                Imagen imagenH2b = new Imagen();
                imagenH2b.setUrl("https://http2.mlstatic.com/D_NQ_NP_773441-MLA42754261815_072020-O.webp");
                imagenH2b.setHerramienta(herramienta2);
                Imagen imagenH2c = new Imagen();
                imagenH2c.setUrl("https://promart.vteximg.com.br/arquivos/ids/637523-1000-1000/112646.jpg?v=637438522285000000");
                imagenH2c.setHerramienta(herramienta2);
                Imagen imagenH2d = new Imagen();
                imagenH2d.setUrl("https://almacenelectricidad.es/418582-large_default/pala-punta-m-a.jpg");
                imagenH2d.setHerramienta(herramienta2);
                Imagen imagenH2e = new Imagen();
                imagenH2e.setUrl("https://hydroenv.com.mx/catalogo/images/pala7273_450.jpg");
                imagenH2e.setHerramienta(herramienta2);

                herramienta2.getImagenes().add(imagenH2a);
                herramienta2.getImagenes().add(imagenH2b);
                herramienta2.getImagenes().add(imagenH2c);
                herramienta2.getImagenes().add(imagenH2d);
                herramienta2.getImagenes().add(imagenH2e);
                categoriaRepository.save(categoria2);
                herramientaRepository.save(herramienta2);


                //BROCA
                Herramienta herramienta3 = new Herramienta();
                Categoria categoria3 = new Categoria();
                categoria3.setTitulo("Construccion");
                categoria3.setIcono("hammer");
                herramienta3.getCaracteristicas().add(caracteristica1);
                herramienta3.getCaracteristicas().add(caracteristica2);
                herramienta3.getCaracteristicas().add(caracteristica3);
                herramienta3.getCaracteristicas().add(caracteristica4);
                herramienta3.getCaracteristicas().add(caracteristica5);
                herramienta3.setCategoria(categoria3);
                herramienta3.setStock(12L);
                herramienta3.setPrecio(50L);
                herramienta3.setDisponibilidad(true);
                herramienta3.setNombre("Broca");

                herramienta3.setDescripcion("\n" +
                        "¡Presentamos la Broca de Carburo UltraDrill, la opción definitiva para perforaciones precisas y eficientes en una variedad de materiales! Diseñada para profesionales y aficionados por igual, esta broca ofrece un rendimiento excepcional y una durabilidad inigualable.");
                //Imagenes Tercera Herramienta
                Imagen imagenH3a = new Imagen();
                imagenH3a.setUrl("https://img.lojadomecanico.com.br/IMAGENS/37/778/113406/Broca-Aco-Rapido-para-Metal-25mm-irwin-18349281.JPG");
                imagenH3a.setHerramienta(herramienta3);
                Imagen imagenH3b = new Imagen();
                imagenH3b.setUrl("https://img.lojadomecanico.com.br/IMAGENS/37/778/113406/Broca-Aco-Rapido-para-Metal-25mm-irwin-18349284.JPG?ims=100x100/filters:quality(50)");
                imagenH3b.setHerramienta(herramienta3);
                Imagen imagenH3c = new Imagen();
                imagenH3c.setUrl("https://img.lojadomecanico.com.br/IMAGENS/37/778/113406/Broca-Aco-Rapido-para-Metal-25mm-irwin-18349283.JPG?ims=100x100/filters:quality(50)");
                imagenH3c.setHerramienta(herramienta3);
                Imagen imagenH3d = new Imagen();
                imagenH3d.setUrl("https://dehumtudo.com.br/wp-content/uploads/2021/12/486aa5c14b4930c11f7d95a676647611-1.jpg");
                imagenH3d.setHerramienta(herramienta3);
                Imagen imagenH3e = new Imagen();
                imagenH3e.setUrl("https://dehumtudo.com.br/wp-content/uploads/2021/12/486aa5c14b4930c11f7d95a676647611-1.jpg");
                imagenH3e.setHerramienta(herramienta3);

                herramienta3.getImagenes().add(imagenH3a);
                herramienta3.getImagenes().add(imagenH3b);
                herramienta3.getImagenes().add(imagenH3c);
                herramienta3.getImagenes().add(imagenH3d);
                herramienta3.getImagenes().add(imagenH3e);
                categoriaRepository.save(categoria3);
                herramientaRepository.save(herramienta3);


                //CINTA METRICA
                Herramienta herramienta4 = new Herramienta();
                herramienta4.setCategoria(categoria3);
                herramienta4.getCaracteristicas().add(caracteristica1);
                herramienta4.getCaracteristicas().add(caracteristica2);
                herramienta4.getCaracteristicas().add(caracteristica3);
                herramienta4.getCaracteristicas().add(caracteristica4);
                herramienta4.getCaracteristicas().add(caracteristica5);
                herramienta4.setStock(15L);
                herramienta4.setPrecio(75L);
                herramienta4.setDisponibilidad(true);
                herramienta4.setNombre("Cinta métrica");

                herramienta4.setDescripcion("\n" +
                        "¡Presentamos la Cinta Métrica ProMeasure, tu herramienta confiable para mediciones precisas en cualquier proyecto! Diseñada para durabilidad y precisión, esta cinta métrica versátil es una adición esencial a cualquier caja de herramientas.");
                //Imagenes Cuarta Herramienta
                Imagen imagenH4a = new Imagen();
                imagenH4a.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Stanley_dynagrip_5_m_%C3%97_19_mm_33-684_01.jpg/800px-Stanley_dynagrip_5_m_%C3%97_19_mm_33-684_01.jpg");
                imagenH4a.setHerramienta(herramienta4);
                Imagen imagenH4b = new Imagen();
                imagenH4b.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCTNcLCpsyH6ANXG-Wq5xWtwyJEoYh5a3X2HyDbzAwAFOSKZBi1zf6T6PdXSvmQEMtrl0&usqp=CAU");
                imagenH4b.setHerramienta(herramienta4);
                Imagen imagenH4c = new Imagen();
                imagenH4c.setUrl("https://http2.mlstatic.com/D_NQ_NP_913102-MLA43737023036_102020-O.webp");
                imagenH4c.setHerramienta(herramienta4);
                Imagen imagenH4d = new Imagen();
                imagenH4d.setUrl("https://crossmaster.com.ar/wp-content/uploads/9932016-600x600.jpg");
                imagenH4d.setHerramienta(herramienta4);
                Imagen imagenH4e = new Imagen();
                imagenH4e.setUrl("https://run.com.ve/wp-content/uploads/2022/01/CM04.jpg");
                imagenH4e.setHerramienta(herramienta4);

                herramienta4.getImagenes().add(imagenH4a);
                herramienta4.getImagenes().add(imagenH4b);
                herramienta4.getImagenes().add(imagenH4c);
                herramienta4.getImagenes().add(imagenH4d);
                herramienta4.getImagenes().add(imagenH4e);

                herramientaRepository.save(herramienta4);



                //LIJADORA
                Herramienta herramienta5 = new Herramienta();
                herramienta5.getCaracteristicas().add(caracteristica1);
                herramienta5.getCaracteristicas().add(caracteristica2);
                herramienta5.getCaracteristicas().add(caracteristica3);
                herramienta5.getCaracteristicas().add(caracteristica4);
                herramienta5.getCaracteristicas().add(caracteristica5);
                herramienta5.setCategoria(categoria3);
                herramienta5.setStock(15L);
                herramienta5.setPrecio(75L);
                herramienta5.setDisponibilidad(true);
                herramienta5.setNombre("Lijadora");

                herramienta5.setDescripcion("\n" +
                        "¡Descubre la Lijadora Orbital ProSander, tu aliada para lograr superficies lisas y pulidas en tus proyectos de carpintería y bricolaje! Esta potente herramienta combina rendimiento, comodidad y versatilidad para satisfacer las necesidades de los profesionales y entusiastas por igual.");
                //Imagenes Quinta Herramienta
                Imagen imagenH5a = new Imagen();
                imagenH5a.setUrl("https://http2.mlstatic.com/D_NQ_NP_944268-MLU73207877259_122023-O.webp");
                imagenH5a.setHerramienta(herramienta5);
                Imagen imagenH5b = new Imagen();
                imagenH5b.setUrl("https://belltec.com.co/1240-large_default/lijadora-rotorbital-5-pulg-industrial-bo5030.jpg");
                imagenH5b.setHerramienta(herramienta5);
                Imagen imagenH5c = new Imagen();
                imagenH5c.setUrl("https://belltec.com.co/1226-large_default/lijadora-orbital-92mm-x-185mm-35-8-x-71-4.jpg");
                imagenH5c.setHerramienta(herramienta5);
                Imagen imagenH5d = new Imagen();
                imagenH5d.setUrl("https://i0.wp.com/ferreteriaelprado.co/wp-content/uploads/2018/08/MAKITA-BO4510NEW.jpg?fit=600%2C600&ssl=1");
                imagenH5d.setHerramienta(herramienta5);
                Imagen imagenH5e = new Imagen();
                imagenH5e.setUrl("https://maquistoresas.com/wp-content/uploads/2021/12/Lijadora-orbital-Makita-180W-M9200B-2.jpg");
                imagenH5e.setHerramienta(herramienta5);

                herramienta5.getImagenes().add(imagenH5a);
                herramienta5.getImagenes().add(imagenH5b);
                herramienta5.getImagenes().add(imagenH5c);
                herramienta5.getImagenes().add(imagenH5d);
                herramienta5.getImagenes().add(imagenH5e);

                herramientaRepository.save(herramienta5);


                //NIVEL
                Herramienta herramienta6 = new Herramienta();
                herramienta6.setCategoria(categoria3);
                herramienta6.getCaracteristicas().add(caracteristica1);
                herramienta6.getCaracteristicas().add(caracteristica2);
                herramienta6.getCaracteristicas().add(caracteristica3);
                herramienta6.getCaracteristicas().add(caracteristica4);
                herramienta6.getCaracteristicas().add(caracteristica5);
                herramienta6.setStock(15L);
                herramienta6.setPrecio(75L);
                herramienta6.setDisponibilidad(true);
                herramienta6.setNombre("Nivel");

                herramienta6.setDescripcion("\n" +
                        "¡Presentamos el Nivelador de Obra ProLine, la herramienta esencial para garantizar la precisión en tus proyectos de construcción! Diseñado para proporcionar mediciones exactas y una nivelación perfecta, este nivelador es la opción ideal para profesionales de la construcción y aficionados por igual.");
                //Imagenes Tercera Herramienta
                Imagen imagenH6a = new Imagen();
                imagenH6a.setUrl("https://upload.wikimedia.org/wikipedia/commons/4/41/Water_level_1.jpg");
                imagenH6a.setHerramienta(herramienta6);
                Imagen imagenH6b = new Imagen();
                imagenH6b.setUrl("https://m.media-amazon.com/images/I/51x6Cb81OLL.jpg");
                imagenH6b.setHerramienta(herramienta6);
                Imagen imagenH6c = new Imagen();
                imagenH6c.setUrl("https://bricomiras.com/cdn/shop/products/nivel-burbuja-1.jpg?v=1636388080");
                imagenH6c.setHerramienta(herramienta6);
                Imagen imagenH6d = new Imagen();
                imagenH6d.setUrl("https://almacen.do/wp-content/uploads/2021/08/Nivel-de-Burbuja-INGCO-Aluminio-16-Front.jpg");
                imagenH6d.setHerramienta(herramienta6);
                Imagen imagenH6e = new Imagen();
                imagenH6e.setUrl("https://almacen.do/wp-content/uploads/2021/08/Nivel-de-Burbuja-INGCO-Aluminio-16-Front.jpg");
                imagenH6e.setHerramienta(herramienta6);

                herramienta6.getImagenes().add(imagenH6a);
                herramienta6.getImagenes().add(imagenH6b);
                herramienta6.getImagenes().add(imagenH6c);
                herramienta6.getImagenes().add(imagenH6d);
                herramienta6.getImagenes().add(imagenH6e);

                herramientaRepository.save(herramienta6);

                //TALADRO
                Herramienta herramienta7 = new Herramienta();
                herramienta7.setCategoria(categoria3);
                herramienta7.getCaracteristicas().add(caracteristica1);
                herramienta7.getCaracteristicas().add(caracteristica2);
                herramienta7.getCaracteristicas().add(caracteristica3);
                herramienta7.getCaracteristicas().add(caracteristica4);
                herramienta7.getCaracteristicas().add(caracteristica5);
                herramienta7.setStock(15L);
                herramienta7.setPrecio(75L);
                herramienta7.setDisponibilidad(true);
                herramienta7.setNombre("Taladro");

                herramienta7.setDescripcion("\n" + "¡Descubre el Taladro Eléctrico ProDrill, tu compañero confiable para todo tipo de perforaciones! Este potente taladro combina rendimiento, durabilidad y versatilidad para satisfacer las demandas de los proyectos más exigentes.");
                //Imagenes Septima Herramienta
                Imagen imagenH7a = new Imagen();
                imagenH7a.setUrl("https://agrostore.co/1310-large_default/taladro-inalambrico-a-bateria-ducati-dud1012ls.jpg");
                imagenH7a.setHerramienta(herramienta7);
                Imagen imagenH7b = new Imagen();
                imagenH7b.setUrl("https://dojiw2m9tvv09.cloudfront.net/76107/product/no-incluye-laptop-33775.png");
                imagenH7b.setHerramienta(herramienta7);
                Imagen imagenH7c = new Imagen();
                imagenH7c.setUrl("https://www.elgrantlapalero.com/media/catalog/product/cache/12e7ea53e5a35d1c8398c84cd286e4ad/r/t/rt303-2_1.jpg");
                imagenH7c.setHerramienta(herramienta7);
                Imagen imagenH7d = new Imagen();
                imagenH7d.setUrl("https://m.media-amazon.com/images/I/618jKvtpGtL._AC_UF894,1000_QL80_.jpg");
                imagenH7d.setHerramienta(herramienta7);
                Imagen imagenH7e = new Imagen();
                imagenH7e.setUrl("https://deutschlandferreteria.com/wp-content/uploads/2021/01/Taladro-Inalambrico-24-Voltios-WSA-TOOLS-ZC-3234-DF-scaled.jpg");
                imagenH7e.setHerramienta(herramienta7);

                herramienta7.getImagenes().add(imagenH7a);
                herramienta7.getImagenes().add(imagenH7b);
                herramienta7.getImagenes().add(imagenH7c);
                herramienta7.getImagenes().add(imagenH7d);
                herramienta7.getImagenes().add(imagenH7e);

                herramientaRepository.save(herramienta7);


                //AMOLADORA
                Herramienta herramienta8 = new Herramienta();
                herramienta8.setCategoria(categoria1);
                herramienta8.getCaracteristicas().add(caracteristica1);
                herramienta8.getCaracteristicas().add(caracteristica2);
                herramienta8.getCaracteristicas().add(caracteristica3);
                herramienta8.getCaracteristicas().add(caracteristica4);
                herramienta8.getCaracteristicas().add(caracteristica5);
                herramienta8.setStock(15L);
                herramienta8.setPrecio(75L);
                herramienta8.setDisponibilidad(true);
                herramienta8.setNombre("Amoladora");

                herramienta8.setDescripcion("La amoladora, la herramienta imprescindible para dar forma y pulir tus creaciones con facilidad. Excelente estado, sin uso. La amoladora, la herramienta imprescindible para dar forma y pulir tus creaciones con facilidad.");
                //Imagenes Octava Herramienta
                Imagen imagenH8a = new Imagen();
                imagenH8a.setUrl("https://i0.wp.com/www.litoralstore.com.ar/wp-content/uploads/2022/05/G720-amoladora-4.jpg");
                imagenH8a.setHerramienta(herramienta8);
                Imagen imagenH8b = new Imagen();
                imagenH8b.setUrl("https://masonlineprod.vtexassets.com/arquivos/ids/305910/Amoladora-Black-Decker-12-Discos-Maletin-G720k12-Ar-1-42972.jpg");
                imagenH8b.setHerramienta(herramienta8);
                Imagen imagenH8c = new Imagen();
                imagenH8c.setUrl("https://www.centrogar.com.ar/6454-medium_default/amoladora-bd-g720-41-2-379.jpg");
                imagenH8c.setHerramienta(herramienta8);
                Imagen imagenH8d = new Imagen();
                imagenH8d.setUrl("https://masonlineprod.vtexassets.com/arquivos/ids/305906/Amoladora-Black-Decker-12-Discos-Maletin-G720k12-Ar-3-42972.jpg");
                imagenH8d.setHerramienta(herramienta8);
                Imagen imagenH8e = new Imagen();
                imagenH8e.setUrl("https://ar.blackanddecker.global/LAG/PRODUCT/IMAGES/HIRES/G650K5-AR/G650K5_1.jpg");
                imagenH8e.setHerramienta(herramienta8);

                herramienta8.getImagenes().add(imagenH8a);
                herramienta8.getImagenes().add(imagenH8b);
                herramienta8.getImagenes().add(imagenH8c);
                herramienta8.getImagenes().add(imagenH8d);
                herramienta8.getImagenes().add(imagenH8e);

                herramientaRepository.save(herramienta8);



                //DESTORNILLADOR
                Herramienta herramienta9 = new Herramienta();
                herramienta9.getCaracteristicas().add(caracteristica1);
                herramienta9.getCaracteristicas().add(caracteristica2);
                herramienta9.getCaracteristicas().add(caracteristica3);
                herramienta9.getCaracteristicas().add(caracteristica4);
                herramienta9.getCaracteristicas().add(caracteristica5);
                herramienta9.setCategoria(categoria1);
                herramienta9.setStock(15L);
                herramienta9.setPrecio(75L);
                herramienta9.setDisponibilidad(true);
                herramienta9.setNombre("Destornillador");

                herramienta9.setDescripcion("¡Descubre el Destornillador de Precisión ProTech, tu herramienta indispensable para trabajos delicados! Este destornillador de alta calidad está diseñado para brindar precisión y durabilidad en cada uso. Con una punta magnética de precisión, este destornillador facilita la manipulación de tornillos pequeños en dispositivos electrónicos, gafas, juguetes y más.");
                //Imagenes Novena Herramienta
                Imagen imagenH9a = new Imagen();
                imagenH9a.setUrl("https://http2.mlstatic.com/D_NQ_NP_836970-MLA40777106135_022020-O.webp");
                imagenH9a.setHerramienta(herramienta9);
                Imagen imagenH9b = new Imagen();
                imagenH9b.setUrl("https://http2.mlstatic.com/D_NQ_NP_910386-MLA48241498865_112021-O.webp");
                imagenH9b.setHerramienta(herramienta9);
                Imagen imagenH9c = new Imagen();
                imagenH9c.setUrl("https://http2.mlstatic.com/D_NQ_NP_747926-MLA72786827115_112023-O.webp");
                imagenH9c.setHerramienta(herramienta9);
                Imagen imagenH9d = new Imagen();
                imagenH9d.setUrl("https://http2.mlstatic.com/D_NQ_NP_784932-MLA47149212072_082021-O.webp");
                imagenH9d.setHerramienta(herramienta9);
                Imagen imagenH9e = new Imagen();
                imagenH9e.setUrl("https://m.media-amazon.com/images/I/61jshsidJLL._AC_UF894,1000_QL80_.jpg");
                imagenH9e.setHerramienta(herramienta9);

                herramienta9.getImagenes().add(imagenH9a);
                herramienta9.getImagenes().add(imagenH9b);
                herramienta9.getImagenes().add(imagenH9c);
                herramienta9.getImagenes().add(imagenH9d);
                herramienta9.getImagenes().add(imagenH9e);

                herramientaRepository.save(herramienta9);

                // MARTILLO
                Herramienta herramienta10 = new Herramienta();
                herramienta10.getCaracteristicas().add(caracteristica1);
                herramienta10.getCaracteristicas().add(caracteristica2);
                herramienta10.getCaracteristicas().add(caracteristica3);
                herramienta10.getCaracteristicas().add(caracteristica4);
                herramienta10.getCaracteristicas().add(caracteristica5);
                herramienta10.setCategoria(categoria3);
                herramienta10.setStock(15L);
                herramienta10.setPrecio(75L);
                herramienta10.setDisponibilidad(true);
                herramienta10.setNombre("Martillo");

                herramienta10.setDescripcion("\n" + "¡Presentamos el Martillo ProStrike, tu herramienta resistente y confiable para una variedad de tareas de construcción y bricolaje! Este martillo está diseñado para ofrecer un rendimiento excepcional y una durabilidad duradera en cualquier proyecto.");
                //Imagenes Decima Herramienta
                Imagen imagenH10a = new Imagen();
                imagenH10a.setUrl("https://cdn.vallejosmateriales.com.ar/720/webp/2022/12/1671799364763-lg-51-274.jpg");
                imagenH10a.setHerramienta(herramienta10);
                Imagen imagenH10b = new Imagen();
                imagenH10b.setUrl("https://m.media-amazon.com/images/I/81zFH45axiL.jpg");
                imagenH10b.setHerramienta(herramienta10);
                Imagen imagenH10c = new Imagen();
                imagenH10c.setUrl("https://http2.mlstatic.com/D_NQ_NP_960514-MLA74423546180_022024-O.webp");
                imagenH10c.setHerramienta(herramienta10);
                Imagen imagenH10d = new Imagen();
                imagenH10d.setUrl("https://http2.mlstatic.com/D_NQ_NP_996428-MLU74471169023_022024-O.webp");
                imagenH10d.setHerramienta(herramienta10);
                Imagen imagenH10e = new Imagen();
                imagenH10e.setUrl("https://www.wurth.com.ar/blog/wp-content/uploads/2022/11/martillo-de-carpintero.jpg");
                imagenH10e.setHerramienta(herramienta10);

                herramienta10.getImagenes().add(imagenH10a);
                herramienta10.getImagenes().add(imagenH10b);
                herramienta10.getImagenes().add(imagenH10c);
                herramienta10.getImagenes().add(imagenH10d);
                herramienta10.getImagenes().add(imagenH10e);

                herramientaRepository.save(herramienta10);



                //Reservas
                Reserva reserva1= new Reserva();
                reserva1.setFechaAlquiler(LocalDate.of(2024,03,14));
                reserva1.setFechaDevolucion(LocalDate.of(2024,03,20));
                reserva1.setUsuarioId(superAdmin);
                reserva1.setHerramientaId(herramienta1);
                Reserva reserva2=new Reserva();
                reserva2.setFechaAlquiler(LocalDate.of(2024,04,15));
                reserva2.setFechaDevolucion(LocalDate.of(2024,04,25));
                reserva2.setUsuarioId(superAdmin);
                reserva2.setHerramientaId(herramienta1);


                reservaRepository.save(reserva2);
                reservaRepository.save(reserva1);


                Reserva reserva3 = new Reserva();
                reserva3.setFechaAlquiler(LocalDate.of(2024, 05, 10));
                reserva3.setFechaDevolucion(LocalDate.of(2024, 05, 20));
                reserva3.setUsuarioId(superAdmin);
                reserva3.setHerramientaId(herramienta2);
                reservaRepository.save(reserva3);

                Reserva reserva4 = new Reserva();
                reserva4.setFechaAlquiler(LocalDate.of(2024, 06, 8));
                reserva4.setFechaDevolucion(LocalDate.of(2024, 06, 18));
                reserva4.setUsuarioId(superAdmin);
                reserva4.setHerramientaId(herramienta3);
                reservaRepository.save(reserva4);

                Reserva reserva5 = new Reserva();
                reserva5.setFechaAlquiler(LocalDate.of(2024, 07, 6));
                reserva5.setFechaDevolucion(LocalDate.of(2024, 07, 16));
                reserva5.setUsuarioId(superAdmin);
                reserva5.setHerramientaId(herramienta4);
                reservaRepository.save(reserva5);

                Reserva reserva6 = new Reserva();
                reserva6.setFechaAlquiler(LocalDate.of(2024, 8, 4));
                reserva6.setFechaDevolucion(LocalDate.of(2024, 8, 14));
                reserva6.setUsuarioId(superAdmin);
                reserva6.setHerramientaId(herramienta5);
                reservaRepository.save(reserva6);

                Reserva reserva7 = new Reserva();
                reserva7.setFechaAlquiler(LocalDate.of(2024, 9, 2));
                reserva7.setFechaDevolucion(LocalDate.of(2024, 9, 12));
                reserva7.setUsuarioId(superAdmin);
                reserva7.setHerramientaId(herramienta6);
                reservaRepository.save(reserva7);


                Reserva reserva8 = new Reserva();
                reserva8.setFechaAlquiler(LocalDate.of(2024, 10, 1));
                reserva8.setFechaDevolucion(LocalDate.of(2024, 10, 11));
                reserva8.setUsuarioId(superAdmin);
                reserva8.setHerramientaId(herramienta7);
                reservaRepository.save(reserva8);

                Reserva reserva9 = new Reserva();
                reserva9.setFechaAlquiler(LocalDate.of(2024, 11, 29));
                reserva9.setFechaDevolucion(LocalDate.of(2024, 12, 9));
                reserva9.setUsuarioId(superAdmin);
                reserva9.setHerramientaId(herramienta8);
                reservaRepository.save(reserva9);

                Reserva reserva10 = new Reserva();
                reserva10.setFechaAlquiler(LocalDate.of(2025, 01, 27));
                reserva10.setFechaDevolucion(LocalDate.of(2025, 02, 6));
                reserva10.setUsuarioId(superAdmin);
                reserva10.setHerramientaId(herramienta9);
                reservaRepository.save(reserva10);




                //Reseñas
                Reseña reseña1= new Reseña();
                reseña1.setComentario("La llave inglesa XYZ es genial. Su diseño ergonómico y ajuste rápido hacen que sea perfecta para cualquier trabajo en casa. Recomendada.");
                reseña1.setRaiting(3L);
                reseña1.setReserva_id(reserva1);
                reseña1.setHerramienta_idReseña(herramienta1);
                reseña1.setFecha(LocalDate.of(2024,03,21));

                Reseña reseña2= new Reseña();
                reseña2.setComentario("¡La pala XYZ superó todas mis expectativas! Su diseño ergonómico hizo que trabajar en el jardín fuera mucho más cómodo");
                reseña2.setRaiting(4L);
                reseña2.setReserva_id(reserva2);
                reseña2.setHerramienta_idReseña(herramienta2);
                reseña2.setFecha(LocalDate.of(2024,03,05));

                Reseña reseña3= new Reseña();
                reseña3.setComentario("¡La broca XYZ es simplemente impresionante! Su diseño robusto y afilado facilitó la perforación a través de diversos materiales, desde madera hasta metal. ");
                reseña3.setRaiting(5L);
                reseña3.setReserva_id(reserva3);
                reseña3.setHerramienta_idReseña(herramienta3);
                reseña3.setFecha(LocalDate.of(2024,03,10));

                Reseña reseña4= new Reseña();
                reseña4.setComentario(
                        "La cinta métrica XYZ es una verdadera joya en mi caja de herramientas. Su durabilidad y precisión han hecho que medir sea una tarea rápida y sencilla en cualquier proyecto.");
                reseña4.setRaiting(4L);
                reseña4.setReserva_id(reserva4);
                reseña4.setHerramienta_idReseña(herramienta4);
                reseña4.setFecha(LocalDate.of(2024,03,11));

                Reseña reseña5= new Reseña();
                reseña5.setComentario("¡La lijadora XYZ ha sido un verdadero salvavidas en mis proyectos de bricolaje! Su potente motor y su diseño ergonómico hacen que lijar sea rápido y eficiente.");
                reseña5.setRaiting(5l);
                reseña5.setReserva_id(reserva5);
                reseña5.setHerramienta_idReseña(herramienta5);
                reseña5.setFecha(LocalDate.of(2024,03,7));

                Reseña reseña6= new Reseña();
                reseña6.setComentario("¡El nivel XYZ hizo que mi proyecto de construcción fuera increíblemente fácil!");
                reseña6.setRaiting(3L);
                reseña6.setReserva_id(reserva6);
                reseña6.setHerramienta_idReseña(herramienta6);
                reseña6.setFecha(LocalDate.of(2024,03,2));

                Reseña reseña7= new Reseña();
                reseña7.setComentario("¡El taladro XYZ fue exactamente lo que necesitaba para mi proyecto en casa! Su potencia y precisión hicieron que perforar fuera rápido y sencillo.");
                reseña7.setRaiting(5L);
                reseña7.setReserva_id(reserva7);
                reseña7.setHerramienta_idReseña(herramienta7);
                reseña7.setFecha(LocalDate.of(2024,03,29));



                Reseña reseña8= new Reseña();
                reseña8.setComentario("La amoladora XYZ ha sido una verdadera revelación en mi taller. Su potencia y versatilidad la convierten en la herramienta perfecta para una amplia gama de tareas de corte y lijado. Estoy realmente impresionado con su rendimiento y facilidad de uso.");
                reseña8.setRaiting(5L);
                reseña8.setReserva_id(reserva8);
                reseña8.setHerramienta_idReseña(herramienta8);
                reseña8.setFecha(LocalDate.of(2024,03,03));


                Reseña reseña9= new Reseña();
                reseña9.setComentario("El destornillador XYZ hizo que mi proyecto de montaje fuera un juego de niños. Su diseño ergonómico y su potencia de torsión hicieron que quitar y poner tornillos fuera rápido y sin esfuerzo.");
                reseña9.setRaiting(2l);
                reseña9.setReserva_id(reserva9);
                reseña9.setHerramienta_idReseña(herramienta9);
                reseña9.setFecha(LocalDate.of(2024,03,21));


                Reseña reseña10= new Reseña();
                reseña10.setComentario("El martillo XYZ ha sido una verdadera joya en mi caja de herramientas.");
                reseña10.setRaiting(3L);
                reseña10.setReserva_id(reserva10);
                reseña10.setHerramienta_idReseña(herramienta10);
                reseña10.setFecha(LocalDate.of(2024,03,05));


                reseñaRepository.save(reseña1);
                reseñaRepository.save(reseña2);
                reseñaRepository.save(reseña3);
                reseñaRepository.save(reseña4);
                reseñaRepository.save(reseña5);
                reseñaRepository.save(reseña6);
                reseñaRepository.save(reseña7);
                reseñaRepository.save(reseña8);
                reseñaRepository.save(reseña9);
                reseñaRepository.save(reseña10);


                //Gonza

                //LLAVE INGLESA 2
                Herramienta herramienta11 = new Herramienta();

                herramienta11.getCaracteristicas().add(caracteristica1);
                herramienta11.getCaracteristicas().add(caracteristica2);
                herramienta11.getCaracteristicas().add(caracteristica3);
                herramienta11.getCaracteristicas().add(caracteristica4);
                herramienta11.getCaracteristicas().add(caracteristica5);
                herramienta11.setCategoria(categoria1);
                herramienta11.setStock(10L);
                herramienta11.setPrecio(50L);
                herramienta11.setDisponibilidad(true);
                herramienta11.setNombre("Llave inglesa Virax");






                herramienta11.setDescripcion("\n" +
                        "¡Te presentamos la Llave GripMaster: tu aliada confiable para tareas mecánicas! Con durabilidad y precisión, es imprescindible en cualquier caja de herramientas. Ajusta fácilmente su tamaño para adaptarse a cualquier tarea. Perfecta para proyectos en casa, bricolaje o trabajo. ¡Confía en su firmeza para realizar el trabajo con maestría!");

                Imagen imagenH11a = new Imagen();
                imagenH11a.setUrl("https://www.virax.com/media/catalog/product/cache/9ceffc1a1584e2467259181601dfd4db/3/4/34166-017031.webp");
                imagenH11a.setHerramienta(herramienta11);
                Imagen imagenH11b = new Imagen();
                imagenH11b.setUrl("https://www.virax.com/media/catalog/product/cache/9ceffc1a1584e2467259181601dfd4db/0/1/017055_pack.webp");
                imagenH11b.setHerramienta(herramienta11);
                Imagen imagenH11c = new Imagen();
                imagenH11c.setUrl("https://www.virax.com/media/catalog/product/cache/9ceffc1a1584e2467259181601dfd4db/3/4/34189-017022.webp");
                imagenH11c.setHerramienta(herramienta11);
                Imagen imagenH11d = new Imagen();
                imagenH11d.setUrl("https://www.virax.com/media/catalog/product/cache/9ceffc1a1584e2467259181601dfd4db/3/4/34189-017022.webp");
                imagenH11d.setHerramienta(herramienta11);
                Imagen imagenH11e = new Imagen();
                imagenH11e.setUrl("https://ronixtools.com/img/media/products/rh-2401/original-637604114727568645.webp");
                imagenH11e.setHerramienta(herramienta11);

                herramienta11.getImagenes().add(imagenH11a);
                herramienta11.getImagenes().add(imagenH11b);
                herramienta11.getImagenes().add(imagenH11c);
                herramienta11.getImagenes().add(imagenH11d);
                herramienta11.getImagenes().add(imagenH11e);

                categoriaRepository.save(categoria1);
                herramientaRepository.save(herramienta11);






                //PALA 2
                Herramienta herramienta12 = new Herramienta();
                herramienta12.getCaracteristicas().add(caracteristica1);
                herramienta12.getCaracteristicas().add(caracteristica2);
                herramienta12.getCaracteristicas().add(caracteristica3);
                herramienta12.getCaracteristicas().add(caracteristica4);
                herramienta12.getCaracteristicas().add(caracteristica5);
                herramienta12.setCategoria(categoria2);
                herramienta12.setStock(12L);
                herramienta12.setPrecio(50L);
                herramienta12.setDisponibilidad(true);
                herramienta12.setNombre("Pala Opack");

                herramienta12.setDescripcion("\n" +

                        "¡Presentamos la Pala TerraGrip: tu herramienta esencial para la jardinería eficiente! Resistente y confiable, esta pala está diseñada para enfrentar una variedad de tareas de jardinería y paisajismo con facilidad.");

                Imagen imagenH12a = new Imagen();
                imagenH12a.setUrl("https://http2.mlstatic.com/D_NQ_NP_754068-MLM42764300444_072020-O.webp");
                imagenH12a.setHerramienta(herramienta12);
                Imagen imagenH12b = new Imagen();
                imagenH12b.setUrl("https://http2.mlstatic.com/D_NQ_NP_758300-MLU74727299592_032024-O.webp");
                imagenH12b.setHerramienta(herramienta12);
                Imagen imagenH12c = new Imagen();
                imagenH12c.setUrl("https://http2.mlstatic.com/D_NQ_NP_995499-MLU73663377343_122023-O.webp");
                imagenH12c.setHerramienta(herramienta12);
                Imagen imagenH12d = new Imagen();
                imagenH12d.setUrl("https://http2.mlstatic.com/D_NQ_NP_760727-MLU74824657428_032024-O.webp");
                imagenH12d.setHerramienta(herramienta12);
                Imagen imagenH12e = new Imagen();
                imagenH12e.setUrl("https://http2.mlstatic.com/D_NQ_NP_700237-MLU73681224131_122023-O.webp");
                imagenH12e.setHerramienta(herramienta12);

                herramienta12.getImagenes().add(imagenH12a);
                herramienta12.getImagenes().add(imagenH12b);
                herramienta12.getImagenes().add(imagenH12c);
                herramienta12.getImagenes().add(imagenH12d);
                herramienta12.getImagenes().add(imagenH12e);
                categoriaRepository.save(categoria2);
                herramientaRepository.save(herramienta12);


                //BROCA
                Herramienta herramienta13 = new Herramienta();

                herramienta13.getCaracteristicas().add(caracteristica1);
                herramienta13.getCaracteristicas().add(caracteristica2);
                herramienta13.getCaracteristicas().add(caracteristica3);
                herramienta13.getCaracteristicas().add(caracteristica4);
                herramienta13.getCaracteristicas().add(caracteristica5);
                herramienta13.setCategoria(categoria3);
                herramienta13.setStock(12L);
                herramienta13.setPrecio(50L);
                herramienta13.setDisponibilidad(true);
                herramienta13.setNombre("Broca Sima");

                herramienta13.setDescripcion("\n" +
                        "¡Descubre la Broca TurboPerf, la revolucionaria herramienta que transformará tus proyectos de perforación! Diseñada con la última tecnología en mente, la Broca TurboPerf te ofrece una combinación perfecta de precisión, potencia y durabilidad. Su diseño aerodinámico y afilado garantiza perforaciones limpias y rápidas.");
                Imagen imagenH13a = new Imagen();
                imagenH13a.setUrl("https://images.pexels.com/photos/6942294/pexels-photo-6942294.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
                imagenH13a.setHerramienta(herramienta13);
                Imagen imagenH13b = new Imagen();
                imagenH13b.setUrl("https://tubagua.es/wp-content/uploads/2023/02/POST-BLOG-TUBAGUA-1.png");
                imagenH13b.setHerramienta(herramienta13);
                Imagen imagenH13c = new Imagen();
                imagenH13c.setUrl("https://www.shutterstock.com/image-photo/metal-drill-bit-make-holes-600nw-2148293791.jpg");
                imagenH13c.setHerramienta(herramienta13);
                Imagen imagenH13d = new Imagen();
                imagenH13d.setUrl("https://http2.mlstatic.com/D_NQ_NP_635177-MLU75358819189_032024-O.webp");
                imagenH13d.setHerramienta(herramienta13);
                Imagen imagenH13e = new Imagen();
                imagenH13e.setUrl("https://http2.mlstatic.com/D_NQ_NP_897206-MLU75021602757_032024-O.webp");
                imagenH13e.setHerramienta(herramienta13);

                herramienta13.getImagenes().add(imagenH13a);
                herramienta13.getImagenes().add(imagenH13b);
                herramienta13.getImagenes().add(imagenH13c);
                herramienta13.getImagenes().add(imagenH13d);
                herramienta13.getImagenes().add(imagenH13e);
                categoriaRepository.save(categoria3);
                herramientaRepository.save(herramienta13);


                //CINTA METRICA
                Herramienta herramienta14 = new Herramienta();
                herramienta14.setCategoria(categoria3);
                herramienta14.getCaracteristicas().add(caracteristica1);
                herramienta14.getCaracteristicas().add(caracteristica2);
                herramienta14.getCaracteristicas().add(caracteristica3);
                herramienta14.getCaracteristicas().add(caracteristica4);
                herramienta14.getCaracteristicas().add(caracteristica5);
                herramienta14.setStock(15L);
                herramienta14.setPrecio(75L);
                herramienta14.setDisponibilidad(true);
                herramienta14.setNombre("Cinta métrica Felo");

                herramienta14.setDescripcion("\n" +

                        "¡Descubre la nueva Cinta Métrica UltraMeasure, tu aliada confiable para mediciones precisas en todo tipo de proyectos! Con un diseño robusto y ergonómico, esta cinta métrica te brinda la precisión y durabilidad que necesitas en cada tarea.");

                Imagen imagenH14a = new Imagen();
                imagenH14a.setUrl("https://http2.mlstatic.com/D_NQ_NP_933510-MLU69867882484_062023-O.webp");
                imagenH14a.setHerramienta(herramienta14);
                Imagen imagenH14b = new Imagen();
                imagenH14b.setUrl("https://http2.mlstatic.com/D_NQ_NP_987896-MLU72530832192_102023-O.webp");
                imagenH14b.setHerramienta(herramienta14);
                Imagen imagenH14c = new Imagen();
                imagenH14c.setUrl("https://http2.mlstatic.com/D_NQ_NP_963845-MLU75157859539_032024-O.webp");
                imagenH14c.setHerramienta(herramienta14);
                Imagen imagenH14d = new Imagen();
                imagenH14d.setUrl("https://http2.mlstatic.com/D_NQ_NP_687547-MLU75158144843_032024-O.webp");
                imagenH14d.setHerramienta(herramienta14);
                Imagen imagenH14e = new Imagen();
                imagenH14e.setUrl("https://http2.mlstatic.com/D_NQ_NP_780465-MLU75359055097_032024-O.webp");
                imagenH14e.setHerramienta(herramienta14);

                herramienta14.getImagenes().add(imagenH14a);
                herramienta14.getImagenes().add(imagenH14b);
                herramienta14.getImagenes().add(imagenH14c);
                herramienta14.getImagenes().add(imagenH14d);
                herramienta14.getImagenes().add(imagenH14e);

                herramientaRepository.save(herramienta14);



                //LIJADORA
                Herramienta herramienta15 = new Herramienta();
                herramienta15.getCaracteristicas().add(caracteristica1);
                herramienta15.getCaracteristicas().add(caracteristica2);
                herramienta15.getCaracteristicas().add(caracteristica3);
                herramienta15.getCaracteristicas().add(caracteristica4);
                herramienta15.getCaracteristicas().add(caracteristica5);
                herramienta15.setCategoria(categoria3);
                herramienta15.setStock(15L);
                herramienta15.setPrecio(75L);
                herramienta15.setDisponibilidad(true);
                herramienta15.setNombre("Lijadora Bosh");

                herramienta15.setDescripcion("\n" +
                        "¡Conoce la Lijadora UltraLiso, tu mejor aliada para obtener superficies suaves y pulidas en tus proyectos de carpintería y bricolaje! Esta increíble herramienta combina potencia, confort y versatilidad para brindarte resultados impecables en cada tarea");

                Imagen imagenH15a = new Imagen();
                imagenH15a.setUrl("https://http2.mlstatic.com/D_NQ_NP_992511-MLU75358480457_032024-O.webp");
                imagenH15a.setHerramienta(herramienta15);
                Imagen imagenH15b = new Imagen();
                imagenH15b.setUrl("https://http2.mlstatic.com/D_NQ_NP_995234-MLU69810667546_062023-O.webp");
                imagenH15b.setHerramienta(herramienta15);
                Imagen imagenH15c = new Imagen();
                imagenH15c.setUrl("https://http2.mlstatic.com/D_NQ_NP_957299-MLU72929402047_112023-O.webp");
                imagenH15c.setHerramienta(herramienta15);
                Imagen imagenH15d = new Imagen();
                imagenH15d.setUrl("https://http2.mlstatic.com/D_NQ_NP_634182-MLU69810667554_062023-O.webp");
                imagenH15d.setHerramienta(herramienta15);
                Imagen imagenH15e = new Imagen();
                imagenH15e.setUrl("https://http2.mlstatic.com/D_NQ_NP_781476-MLU75210326170_032024-O.webp");
                imagenH15e.setHerramienta(herramienta15);

                herramienta15.getImagenes().add(imagenH15a);
                herramienta15.getImagenes().add(imagenH15b);
                herramienta15.getImagenes().add(imagenH15c);
                herramienta15.getImagenes().add(imagenH15d);
                herramienta15.getImagenes().add(imagenH15e);

                herramientaRepository.save(herramienta15);


                //NIVEL
                Herramienta herramienta16 = new Herramienta();
                herramienta16.setCategoria(categoria3);
                herramienta16.getCaracteristicas().add(caracteristica1);
                herramienta16.getCaracteristicas().add(caracteristica2);
                herramienta16.getCaracteristicas().add(caracteristica3);
                herramienta16.getCaracteristicas().add(caracteristica4);
                herramienta16.getCaracteristicas().add(caracteristica5);
                herramienta16.setStock(15L);
                herramienta16.setPrecio(75L);
                herramienta16.setDisponibilidad(true);
                herramienta16.setNombre("Nivel  ICS");

                herramienta16.setDescripcion("\n" +
                        "¡Descubre el MasterLevel, tu clave para precisión absoluta en cada construcción! Este instrumento garantiza mediciones exactas y una nivelación impecable, siendo esencial para profesionales y aficionados.");
                //Imagenes Tercera Herramienta
                Imagen imagenH16a = new Imagen();
                imagenH16a.setUrl("https://http2.mlstatic.com/D_NQ_NP_841257-MLU74161176845_012024-O.webp");
                imagenH16a.setHerramienta(herramienta16);
                Imagen imagenH16b = new Imagen();
                imagenH16b.setUrl("https://http2.mlstatic.com/D_NQ_NP_974482-MLU75133311637_032024-O.webp");
                imagenH16b.setHerramienta(herramienta16);
                Imagen imagenH16c = new Imagen();
                imagenH16c.setUrl("https://http2.mlstatic.com/D_NQ_NP_641995-MLU75133311643_032024-O.webp");
                imagenH16c.setHerramienta(herramienta16);
                Imagen imagenH16d = new Imagen();
                imagenH16d.setUrl("https://http2.mlstatic.com/D_NQ_NP_718097-MLU75027530962_032024-O.webp");
                imagenH16d.setHerramienta(herramienta16);
                Imagen imagenH16e = new Imagen();
                imagenH16e.setUrl("https://http2.mlstatic.com/D_NQ_NP_788296-MLU74162101599_012024-O.webp");
                imagenH16e.setHerramienta(herramienta16);

                herramienta16.getImagenes().add(imagenH16a);
                herramienta16.getImagenes().add(imagenH16b);
                herramienta16.getImagenes().add(imagenH16c);
                herramienta16.getImagenes().add(imagenH16d);
                herramienta16.getImagenes().add(imagenH16e);

                herramientaRepository.save(herramienta16);

                //TALADRO
                Herramienta herramienta17 = new Herramienta();
                herramienta17.setCategoria(categoria3);
                herramienta17.getCaracteristicas().add(caracteristica1);
                herramienta17.getCaracteristicas().add(caracteristica2);
                herramienta17.getCaracteristicas().add(caracteristica3);
                herramienta17.getCaracteristicas().add(caracteristica4);
                herramienta17.getCaracteristicas().add(caracteristica5);
                herramienta17.setStock(15L);
                herramienta17.setPrecio(75L);
                herramienta17.setDisponibilidad(true);
                herramienta17.setNombre("Taladro  Bosh ");

                herramienta17.setDescripcion("\n" +
                        "¡Conoce el PowerDrill, tu aliado confiable para perforaciones de todo tipo! Este taladro eléctrico potente te ofrece rendimiento, durabilidad y versatilidad en un paquete compacto. Desde reparaciones en casa hasta proyectos profesionales.");
                //Imagenes Septima Herramienta
                Imagen imagenH17a = new Imagen();
                imagenH17a.setUrl("https://http2.mlstatic.com/D_NQ_NP_940549-MLA42693899652_072020-O.webp");
                imagenH17a.setHerramienta(herramienta17);
                Imagen imagenH17b = new Imagen();
                imagenH17b.setUrl("https://http2.mlstatic.com/D_NQ_NP_851954-MLA51774981235_092022-O.webp");
                imagenH17b.setHerramienta(herramienta17);
                Imagen imagenH17c = new Imagen();
                imagenH17c.setUrl("https://http2.mlstatic.com/D_NQ_NP_809296-MLA51774945177_092022-O.webp");
                imagenH17c.setHerramienta(herramienta17);
                Imagen imagenH17d = new Imagen();
                imagenH17d.setUrl("https://http2.mlstatic.com/D_NQ_NP_900481-MLA51774945222_092022-O.webp");
                imagenH17d.setHerramienta(herramienta17);
                Imagen imagenH17e = new Imagen();
                imagenH17e.setUrl("https://http2.mlstatic.com/D_NQ_NP_874629-MLA51774945223_092022-O.webp");
                imagenH17e.setHerramienta(herramienta17);

                herramienta17.getImagenes().add(imagenH17a);
                herramienta17.getImagenes().add(imagenH17b);
                herramienta17.getImagenes().add(imagenH17c);
                herramienta17.getImagenes().add(imagenH17d);
                herramienta17.getImagenes().add(imagenH17e);

                herramientaRepository.save(herramienta17);


                //AMOLADORA
                Herramienta herramienta18 = new Herramienta();
                herramienta18.setCategoria(categoria1);
                herramienta18.getCaracteristicas().add(caracteristica1);
                herramienta18.getCaracteristicas().add(caracteristica2);
                herramienta18.getCaracteristicas().add(caracteristica3);
                herramienta18.getCaracteristicas().add(caracteristica4);
                herramienta18.getCaracteristicas().add(caracteristica5);
                herramienta18.setStock(15L);
                herramienta18.setPrecio(75L);
                herramienta18.setDisponibilidad(true);
                herramienta18.setNombre("Amoladora Makita");

                herramienta18.setDescripcion("\n" +
                        "¡Presentamos la Máquina de Pulir PrimeShape, la clave para esculpir y darle brillo a tus creaciones con facilidad! En perfecto estado y sin uso previo, esta máquina de pulir ofrece resultados excepcionales en cada aplicación");
                //Imagenes Octava Herramienta
                Imagen imagenH18a = new Imagen();
                imagenH18a.setUrl("https://http2.mlstatic.com/D_NQ_NP_634645-MLU72847339069_112023-O.webp");
                imagenH18a.setHerramienta(herramienta18);
                Imagen imagenH18b = new Imagen();
                imagenH18b.setUrl("https://http2.mlstatic.com/D_NQ_NP_998608-MLU74244275555_012024-O.webp");
                imagenH18b.setHerramienta(herramienta18);
                Imagen imagenH18c = new Imagen();
                imagenH18c.setUrl("https://http2.mlstatic.com/D_NQ_NP_997303-MLU72771033846_112023-O.webp");
                imagenH18c.setHerramienta(herramienta18);
                Imagen imagenH18d = new Imagen();
                imagenH18d.setUrl("https://http2.mlstatic.com/D_NQ_NP_857625-MLA50333771165_062022-O.webp");
                imagenH18d.setHerramienta(herramienta18);
                Imagen imagenH18e = new Imagen();
                imagenH18e.setUrl("https://http2.mlstatic.com/D_NQ_NP_745686-MLU69827894891_062023-O.webp");
                imagenH18e.setHerramienta(herramienta18);

                herramienta18.getImagenes().add(imagenH18a);
                herramienta18.getImagenes().add(imagenH18b);
                herramienta18.getImagenes().add(imagenH18c);
                herramienta18.getImagenes().add(imagenH18d);
                herramienta18.getImagenes().add(imagenH18e);

                herramientaRepository.save(herramienta18);



                //DESTORNILLADOR
                Herramienta herramienta19 = new Herramienta();
                herramienta19.getCaracteristicas().add(caracteristica1);
                herramienta19.getCaracteristicas().add(caracteristica2);
                herramienta19.getCaracteristicas().add(caracteristica3);
                herramienta19.getCaracteristicas().add(caracteristica4);
                herramienta19.getCaracteristicas().add(caracteristica5);
                herramienta19.setCategoria(categoria1);
                herramienta19.setStock(15L);
                herramienta19.setPrecio(75L);
                herramienta19.setDisponibilidad(true);
                herramienta19.setNombre("Destornillador Makita ");

                herramienta19.setDescripcion("\n" +
                        "¡Presentamos el UltraGrip, la elección perfecta para trabajos de precisión! Este destornillador de alta calidad te ofrece la precisión y durabilidad que necesitas en cada tarea.Simplifica tus proyectos con el UltraGrip y lleva tu artesanía al siguiente nivel. ¡Hazte con el tuyo hoy mismo y descubre la diferencia!");
                //Imagenes Novena Herramienta
                Imagen imagenH19a = new Imagen();
                imagenH19a.setUrl("https://http2.mlstatic.com/D_NQ_NP_799090-MLA75070872062_032024-O.webp");
                imagenH19a.setHerramienta(herramienta19);
                Imagen imagenH19b = new Imagen();
                imagenH19b.setUrl("https://http2.mlstatic.com/D_NQ_NP_805072-MLA75071017260_032024-O.webp");
                imagenH19b.setHerramienta(herramienta19);
                Imagen imagenH19c = new Imagen();
                imagenH19c.setUrl("https://http2.mlstatic.com/D_NQ_NP_735157-MLA75070988518_032024-O.webp");
                imagenH19c.setHerramienta(herramienta19);
                Imagen imagenH19d = new Imagen();
                imagenH19d.setUrl("https://http2.mlstatic.com/D_NQ_NP_663133-MLU74181372217_012024-O.webp");
                imagenH19d.setHerramienta(herramienta19);
                Imagen imagenH19e = new Imagen();
                imagenH19e.setUrl("https://http2.mlstatic.com/D_NQ_NP_928608-MLU74123413101_012024-O.webp");
                imagenH19e.setHerramienta(herramienta19);

                herramienta19.getImagenes().add(imagenH19a);
                herramienta19.getImagenes().add(imagenH19b);
                herramienta19.getImagenes().add(imagenH19c);
                herramienta19.getImagenes().add(imagenH19d);
                herramienta19.getImagenes().add(imagenH19e);

                herramientaRepository.save(herramienta19);

                // MARTILLO
                Herramienta herramienta20 = new Herramienta();
                herramienta20.getCaracteristicas().add(caracteristica1);
                herramienta20.getCaracteristicas().add(caracteristica2);
                herramienta20.getCaracteristicas().add(caracteristica3);
                herramienta20.getCaracteristicas().add(caracteristica4);
                herramienta20.getCaracteristicas().add(caracteristica5);
                herramienta20.setCategoria(categoria3);
                herramienta20.setStock(15L);
                herramienta20.setPrecio(75L);
                herramienta20.setDisponibilidad(true);
                herramienta20.setNombre("Martillo  Sima");

                herramienta20.setDescripcion("\n" + "¡Descubre el ThunderHammer, la herramienta definitiva para cualquier proyecto de construcción! Este martillo de alta calidad te ofrece potencia y durabilidad inigualables en cada golpe. Con su mango ergonómico y cabeza de acero forjado");
                //Imagenes Decima Herramienta
                Imagen imagenH20a = new Imagen();
                imagenH20a.setUrl("https://http2.mlstatic.com/D_NQ_NP_772723-MLU73209854815_122023-O.webp");
                imagenH20a.setHerramienta(herramienta20);
                Imagen imagenH20b = new Imagen();
                imagenH20b.setUrl("https://http2.mlstatic.com/D_NQ_NP_633564-MLU72612921101_112023-O.webp");
                imagenH20b.setHerramienta(herramienta20);
                Imagen imagenH20c = new Imagen();
                imagenH20c.setUrl("https://http2.mlstatic.com/D_NQ_NP_660053-MLU70406708314_072023-O.webp");
                imagenH20c.setHerramienta(herramienta20);
                Imagen imagenH20d = new Imagen();
                imagenH20d.setUrl("https://http2.mlstatic.com/D_NQ_NP_835567-MLU74089579428_012024-O.webp");
                imagenH20d.setHerramienta(herramienta20);
                Imagen imagenH20e = new Imagen();
                imagenH20e.setUrl("https://http2.mlstatic.com/D_NQ_NP_812758-MLU70415548245_072023-O.webp");
                imagenH20e.setHerramienta(herramienta20);

                herramienta20.getImagenes().add(imagenH20a);
                herramienta20.getImagenes().add(imagenH20b);
                herramienta20.getImagenes().add(imagenH20c);
                herramienta20.getImagenes().add(imagenH20d);
                herramienta20.getImagenes().add(imagenH20e);

                herramientaRepository.save(herramienta20);



                //Reservas
                Reserva reserva11= new Reserva();
                reserva11.setFechaAlquiler(LocalDate.of(2024,04,18));
                reserva11.setFechaDevolucion(LocalDate.of(2024,04,28));
                reserva11.setUsuarioId(superAdmin);
                reserva11.setHerramientaId(herramienta11);
                reservaRepository.save(reserva11);

                Reserva reserva12= new Reserva();
                reserva12.setFechaAlquiler(LocalDate.of(2024,05,14));
                reserva12.setFechaDevolucion(LocalDate.of(2024,05,18));
                reserva12.setUsuarioId(superAdmin);
                reserva12.setHerramientaId(herramienta11);
                reservaRepository.save(reserva12);

                Reserva reserva13 = new Reserva();
                reserva13.setFechaAlquiler(LocalDate.of(2024, 06, 8));
                reserva13.setFechaDevolucion(LocalDate.of(2024, 06, 18));
                reserva13.setUsuarioId(superAdmin);
                reserva13.setHerramientaId(herramienta12);
                reservaRepository.save(reserva13);

                Reserva reserva14 = new Reserva();
                reserva14.setFechaAlquiler(LocalDate.of(2024, 06, 10));
                reserva14.setFechaDevolucion(LocalDate.of(2024, 06, 20));
                reserva14.setUsuarioId(superAdmin);
                reserva14.setHerramientaId(herramienta13);
                reservaRepository.save(reserva14);

                Reserva reserva15 = new Reserva();
                reserva15.setFechaAlquiler(LocalDate.of(2024, 07, 9));
                reserva15.setFechaDevolucion(LocalDate.of(2024, 07, 19));
                reserva15.setUsuarioId(superAdmin);
                reserva15.setHerramientaId(herramienta14);
                reservaRepository.save(reserva15);

                Reserva reserva16 = new Reserva();
                reserva16.setFechaAlquiler(LocalDate.of(2024, 8, 5));
                reserva16.setFechaDevolucion(LocalDate.of(2024, 8, 15));
                reserva16.setUsuarioId(superAdmin);
                reserva16.setHerramientaId(herramienta15);
                reservaRepository.save(reserva16);

                Reserva reserva17 = new Reserva();
                reserva17.setFechaAlquiler(LocalDate.of(2024, 10, 10));
                reserva17.setFechaDevolucion(LocalDate.of(2024, 10, 20));
                reserva17.setUsuarioId(superAdmin);
                reserva17.setHerramientaId(herramienta16);
                reservaRepository.save(reserva17);


                Reserva reserva18 = new Reserva();
                reserva18.setFechaAlquiler(LocalDate.of(2024, 10, 21));
                reserva18.setFechaDevolucion(LocalDate.of(2024, 10, 31));
                reserva18.setUsuarioId(superAdmin);
                reserva18.setHerramientaId(herramienta17);
                reservaRepository.save(reserva18);

                Reserva reserva19 = new Reserva();
                reserva19.setFechaAlquiler(LocalDate.of(2024, 11, 9));
                reserva19.setFechaDevolucion(LocalDate.of(2024, 11, 19));
                reserva19.setUsuarioId(superAdmin);
                reserva19.setHerramientaId(herramienta18);
                reservaRepository.save(reserva19);

                Reserva reserva20 = new Reserva();
                reserva20.setFechaAlquiler(LocalDate.of(2025, 01, 20));
                reserva20.setFechaDevolucion(LocalDate.of(2025, 02, 1));
                reserva20.setUsuarioId(superAdmin);
                reserva20.setHerramientaId(herramienta19);
                reservaRepository.save(reserva20);

                Reserva reserva21=new Reserva();
                reserva21.setFechaAlquiler(LocalDate.of(2024,06,28));
                reserva21.setFechaDevolucion(LocalDate.of(2024,07,5));
                reserva21.setUsuarioId(superAdmin);
                reserva21.setHerramientaId(herramienta20);
                reservaRepository.save(reserva21);


                //Reseñas
                Reseña reseña11= new Reseña();
                reseña11.setComentario("La llave inglesa GripMaster es genial,su material parece ser de gran durabilidad.");
                reseña11.setRaiting(3L);
                reseña11.setReserva_id(reserva11);
                reseña11.setHerramienta_idReseña(herramienta11);
                reseña11.setFecha(LocalDate.of(2024,04,29));

                Reseña reseña12= new Reseña();
                reseña12.setComentario("¡La pala TerraGrip es insuperable, su rendimiento es impresionante.Imprescindible para cualquier proyecto de jardinería o construcción.");
                reseña12.setRaiting(4L);
                reseña12.setReserva_id(reserva12);
                reseña12.setHerramienta_idReseña(herramienta12);
                reseña12.setFecha(LocalDate.of(2024,06,20));

                Reseña reseña13= new Reseña();
                reseña13.setComentario("¡La broca TurboPerf tiene un diseño afilado y duradero, me permite perforaciones limpias y precisas en una variedad de materiales, recomendada. ");
                reseña13.setRaiting(5L);
                reseña13.setReserva_id(reserva13);
                reseña13.setHerramienta_idReseña(herramienta13);
                reseña13.setFecha(LocalDate.of(2024,06,25));

                Reseña reseña14= new Reseña();
                reseña14.setComentario("La cinta UltraMeasure es simplemente asombrosa,su longitud generosa la hace perfecta para una amplia gama de proyectos.");
                reseña14.setRaiting(4L);
                reseña14.setReserva_id(reserva14);
                reseña14.setHerramienta_idReseña(herramienta14);
                reseña14.setFecha(LocalDate.of(2024,07,22));

                Reseña reseña15= new Reseña();
                reseña15.setComentario("¡La lijadora UltraLiso tiene una potencia y diseño ergonómico perfectos, es como tener un as bajo la manga para cualquier proyecto de bricolaje. Además, ¡es super fácil de usar! ");
                reseña15.setRaiting(5l);
                reseña15.setReserva_id(reserva15);
                reseña15.setHerramienta_idReseña(herramienta15);
                reseña15.setFecha(LocalDate.of(2024,8,18));

                Reseña reseña16= new Reseña();
                reseña16.setComentario("¡El nivel MasterLevel es genial! Es como tener a tu propio asistente de nivelación. ");
                reseña16.setRaiting(3L);
                reseña16.setReserva_id(reserva16);
                reseña16.setHerramienta_idReseña(herramienta16);
                reseña16.setFecha(LocalDate.of(2024,10,30));

                Reseña reseña17= new Reseña();
                reseña17.setComentario("¡El taladro PowerDrill es tu compañero perfecto, es una bestia! ");
                reseña17.setRaiting(5L);
                reseña17.setReserva_id(reserva17);
                reseña17.setHerramienta_idReseña(herramienta17);
                reseña17.setFecha(LocalDate.of(2024,11,5));



                Reseña reseña18= new Reseña();
                reseña18.setComentario("La amoladora PrimeShape es tu mejor aliada en cualquier tarea de reparación o mejora en casa. ¡Prepárate para hacer maravillas con tus proyectos!");
                reseña18.setRaiting(5L);
                reseña18.setReserva_id(reserva18);
                reseña18.setHerramienta_idReseña(herramienta18);
                reseña18.setFecha(LocalDate.of(2024,03,03));


                Reseña reseña19= new Reseña();
                reseña19.setComentario("Con su diseño compacto y fácil agarre este Destornillador es genial, ¡es como tener un superpoder en la palma de tu mano! ");
                reseña19.setRaiting(2l);
                reseña19.setReserva_id(reserva19);
                reseña19.setHerramienta_idReseña(herramienta19);
                reseña19.setFecha(LocalDate.of(2025,03,1));


                Reseña reseña20= new Reseña();
                reseña20.setComentario("El martillo te hace sentir como un superhéroe cada vez que lo usas, Ya sea para clavar clavos o romper cosas, este martillo es tu mejor amigo en el taller ");
                reseña20.setRaiting(3L);
                reseña20.setReserva_id(reserva20);
                reseña20.setHerramienta_idReseña(herramienta20);
                reseña20.setFecha(LocalDate.of(2024,07,15));


                reseñaRepository.save(reseña11);
                reseñaRepository.save(reseña12);
                reseñaRepository.save(reseña13);
                reseñaRepository.save(reseña14);
                reseñaRepository.save(reseña15);
                reseñaRepository.save(reseña16);
                reseñaRepository.save(reseña17);
                reseñaRepository.save(reseña18);
                reseñaRepository.save(reseña19);
                reseñaRepository.save(reseña20);




}
        }