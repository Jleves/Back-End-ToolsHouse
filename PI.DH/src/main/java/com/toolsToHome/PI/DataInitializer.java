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





                Usuario superAdmin = Usuario.builder()
                        .email("superadmin@toolshouse.com")
                        .password(passwordEncoder.bCryptPasswordEncoder().encode("admin"))
                        .nombre("Super")
                        .apellido("Admin")
                        .ciudad("El Espacio Exterior")
                        .usuarioRole(UsuarioRole.SUPERADMIN)
                        .build();

                usuarioRepository.save(superAdmin);




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






                herramienta1.setDescripcion("La llave inglesa, tu solución todo en uno para ajustes precisos.");

                Imagen imagenH1a = new Imagen();
                imagenH1a.setUrl("https://www.shutterstock.com/image-photo/adjustable-spanner-isolated-on-white-260nw-1794553030.jpg");
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

                herramienta2.setDescripcion("La pala, tu compañera confiable para cualquier trabajo de jardinería y construcción.");

                Imagen imagenH2a = new Imagen();
                imagenH2a.setUrl("https://www.incom.mx/img_catalog/SURTEK_130600-PALA_REDONDA_DE_30-F1.webp");
                imagenH2a.setHerramienta(herramienta2);
                Imagen imagenH2b = new Imagen();
                imagenH2b.setUrl("https://www.doitcenter.com.pa/cdn/shop/products/31211321.jpg?v=1703190981");
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

                herramienta3.setDescripcion("La broca, tu herramienta imprescindible para perforar agujeros precisos en una variedad de materiales.");

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

                herramienta4.setDescripcion("La cinta métrica, tu aliada indispensable para mediciones precisas en cualquier proyecto.");

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

                herramienta5.setDescripcion("La lijadora, tu herramienta esencial para obtener acabados suaves y profesionales en tus proyectos de carpintería y bricolaje.");

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

                herramienta6.setDescripcion("El nivel, tu socio confiable para asegurar la precisión en cualquier proyecto de construcción y decoración.");

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

                herramienta7.setDescripcion("El taladro, el motor de tus proyectos más ambiciosos. Con su potencia y precisión, el taladro perfora superficies con facilidad.");

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

                herramienta8.setDescripcion("La amoladora, la herramienta imprescindible para dar forma y pulir tus creaciones con facilidad.");

                Imagen imagenH8a = new Imagen();
                imagenH8a.setUrl("https://i0.wp.com/www.litoralstore.com.ar/wp-content/uploads/2022/05/G720-amoladora-4.jpg?fit=1200%2C801&ssl=1");
                imagenH8a.setHerramienta(herramienta8);
                Imagen imagenH8b = new Imagen();
                imagenH8b.setUrl("https://masonlineprod.vtexassets.com/arquivos/ids/305910/Amoladora-Black-Decker-12-Discos-Maletin-G720k12-Ar-1-42972.jpg?v=638350005718170000");
                imagenH8b.setHerramienta(herramienta8);
                Imagen imagenH8c = new Imagen();
                imagenH8c.setUrl("https://www.centrogar.com.ar/6454-medium_default/amoladora-bd-g720-41-2-379.jpg");
                imagenH8c.setHerramienta(herramienta8);
                Imagen imagenH8d = new Imagen();
                imagenH8d.setUrl("https://masonlineprod.vtexassets.com/arquivos/ids/305906/Amoladora-Black-Decker-12-Discos-Maletin-G720k12-Ar-3-42972.jpg?v=638350005703070000");
                imagenH8d.setHerramienta(herramienta8);
                Imagen imagenH8e = new Imagen();
                imagenH8e.setUrl("https://ar.blackanddecker.global/LAG/PRODUCT/IMAGES/HIRES/G650K5-AR/G650K5_1.jpg?resize=530x530");
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

                herramienta9.setDescripcion("El destornillador, el héroe discreto de cualquier caja de herramientas.");

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
                imagenH9e.setUrl("https://http2.mlstatic.com/D_NQ_NP_982719-MLA28984973985_122018-O.webp");
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

                herramienta10.setDescripcion("El martillo, un aliado esencial en todo proyecto de construcción y bricolaje.");

                Imagen imagenH10a = new Imagen();
                imagenH10a.setUrl("https://tecnitool.es/images/2022/09/tipos-de-martillos.jpg");
                imagenH10a.setHerramienta(herramienta10);
                Imagen imagenH10b = new Imagen();
                imagenH10b.setUrl("https://m.media-amazon.com/images/I/81zFH45axiL.jpg");
                imagenH10b.setHerramienta(herramienta10);
                Imagen imagenH10c = new Imagen();
                imagenH10c.setUrl("Poner otra URL más corta"); //Agrgegar aqui otra URL luego :,vv - Angel
                imagenH10c.setHerramienta(herramienta10);
                Imagen imagenH10d = new Imagen();
                imagenH10d.setUrl("https://i0.wp.com/blog.claroshop.com/wp-content/uploads/2021/08/img_martillo-clavar-1280x720-1.jpg?resize=616%2C347&ssl=1");
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



        }
}