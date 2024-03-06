package com.toolsToHome.PI;

import com.toolsToHome.PI.Model.Imagen;
import com.toolsToHome.PI.Service.AuthService;
import com.toolsToHome.PI.Service.UserService;
import com.toolsToHome.PI.User.Role;
import com.toolsToHome.PI.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.toolsToHome.PI.Model.Herramienta;
import com.toolsToHome.PI.Repository.HerramientaRepository;

import java.awt.*;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final HerramientaRepository herramientaRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public DataInitializer(HerramientaRepository herramientaRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.herramientaRepository = herramientaRepository;
        this.userService = userService;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void run(String... args) {


        //Creación del superadmin
          User superAdmin = User.builder()
                    .username("superadmin@toolshouse.com")
                    .password(passwordEncoder.encode("admin"))
                    .nombre("Super")
                    .apellido("Admin")
                    .role(Role.SUPER_ADMIN)
                    .build();

            userService.save(superAdmin);

            //Creacion de ADMIN
        User admin = User.builder()
                .username("admin@toolshouse.com")
                .password(passwordEncoder.encode("admin"))
                .nombre("Super")
                .apellido("Admin")
                .role(Role.ADMIN)
                .build();
         userService.save(admin);

        // Creación de productos

        //LLAVE INGLESA
        Herramienta herramienta1 = new Herramienta();
        herramienta1.setCategoria("...");
        herramienta1.setStock(10L);
        herramienta1.setPrecio(50L);
        herramienta1.setDisponibilidad(true);
        herramienta1.setNombre("Llave inglesa");
        herramienta1.setMarca("X");
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

        herramientaRepository.save(herramienta1);


        //PALA
        Herramienta herramienta2 = new Herramienta();
        herramienta2.setCategoria("...");
        herramienta2.setStock(12L);
        herramienta2.setPrecio(50L);
        herramienta2.setDisponibilidad(true);
        herramienta2.setNombre("Pala");
        herramienta2.setMarca("Y");
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

        herramientaRepository.save(herramienta2);


        //BROCA
        Herramienta herramienta3 = new Herramienta();
        herramienta3.setCategoria("...");
        herramienta3.setStock(12L);
        herramienta3.setPrecio(50L);
        herramienta3.setDisponibilidad(true);
        herramienta3.setNombre("Broca");
        herramienta3.setMarca("Y");
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

        herramienta3.getImagenes().add(imagenH3a);
        herramienta3.getImagenes().add(imagenH3b);
        herramienta3.getImagenes().add(imagenH3c);
        herramienta3.getImagenes().add(imagenH3d);
        herramienta3.getImagenes().add(imagenH3e);

        herramientaRepository.save(herramienta3);


        //CINTA METRICA
        Herramienta herramienta4 = new Herramienta();
        herramienta4.setCategoria("...");
        herramienta4.setStock(15L);
        herramienta4.setPrecio(75L);
        herramienta4.setDisponibilidad(true);
        herramienta4.setNombre("Cinta métrica");
        herramienta4.setMarca("Z");
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
        herramienta5.setCategoria("...");
        herramienta5.setStock(15L);
        herramienta5.setPrecio(75L);
        herramienta5.setDisponibilidad(true);
        herramienta5.setNombre("Lijadora");
        herramienta5.setMarca("X");
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

        herramienta5.getImagenes().add(imagenH5a);
        herramienta5.getImagenes().add(imagenH5b);
        herramienta5.getImagenes().add(imagenH5c);
        herramienta5.getImagenes().add(imagenH5d);
        herramienta5.getImagenes().add(imagenH5e);

        herramientaRepository.save(herramienta5);


        //NIVEL
        Herramienta herramienta6 = new Herramienta();
        herramienta6.setCategoria("...");
        herramienta6.setStock(15L);
        herramienta6.setPrecio(75L);
        herramienta6.setDisponibilidad(true);
        herramienta6.setNombre("Nivel");
        herramienta6.setMarca("Z");
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
        herramienta7.setCategoria("...");
        herramienta7.setStock(15L);
        herramienta7.setPrecio(75L);
        herramienta7.setDisponibilidad(true);
        herramienta7.setNombre("Taladro");
        herramienta7.setMarca("Z");
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
        herramienta8.setCategoria("...");
        herramienta8.setStock(15L);
        herramienta8.setPrecio(75L);
        herramienta8.setDisponibilidad(true);
        herramienta8.setNombre("Amoladora");
        herramienta8.setMarca("Z");
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

        herramienta8.getImagenes().add(imagenH8a);
        herramienta8.getImagenes().add(imagenH8b);
        herramienta8.getImagenes().add(imagenH8c);
        herramienta8.getImagenes().add(imagenH8d);
        herramienta8.getImagenes().add(imagenH8e);

        herramientaRepository.save(herramienta8);



        //DESTORNILLADOR
        Herramienta herramienta9 = new Herramienta();
        herramienta9.setCategoria("...");
        herramienta9.setStock(15L);
        herramienta9.setPrecio(75L);
        herramienta9.setDisponibilidad(true);
        herramienta9.setNombre("Destornillador");
        herramienta9.setMarca("Z");
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
        herramienta10.setCategoria("...");
        herramienta10.setStock(15L);
        herramienta10.setPrecio(75L);
        herramienta10.setDisponibilidad(true);
        herramienta10.setNombre("Martillo");
        herramienta10.setMarca("Z");
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


    }
}

