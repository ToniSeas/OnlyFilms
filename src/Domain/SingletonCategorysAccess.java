package Domain;

import java.io.IOException;

import Utility.ResourcesPath;
import Utility.ContentType;
import Utility.GenderList;

public class SingletonCategorysAccess {

	private static SingletonCategorysAccess categoryAccess;
	private Category categoryInUse;
	private CategoryList categoryList;

	private SingletonCategorysAccess() {
		this.categoryInUse = null;
	} // Fin del constructor

	public static SingletonCategorysAccess getInstance() throws IOException {

		if (categoryAccess == null) {
			categoryAccess = new SingletonCategorysAccess();
		}

		return categoryAccess;

	} // Fin de getInstance

	public void loadCategoryNodes() throws IOException {

		this.categoryList = new CategoryList();

		Category comedy = new Category(GenderList.COMEDY, ResourcesPath.COMEDY, ResourcesPath.COMEDYSELEC, null);
		Category action = new Category(GenderList.ACTION, ResourcesPath.ACTION, ResourcesPath.ACTIONSELEC, null);
		Category terror = new Category(GenderList.TERROR, ResourcesPath.TERROR, ResourcesPath.TERRORSELEC, null);
		Category adventure = new Category(GenderList.ADVENTURE, ResourcesPath.ADVENTURE,
				ResourcesPath.ADVENTURESELEC, null);
		Category fiction = new Category(GenderList.FICTION, ResourcesPath.FICTION, ResourcesPath.FICTIONSELEC,
				null);
		Category romantic = new Category(GenderList.ROMANTIC, ResourcesPath.ROMANTIC, ResourcesPath.ROMANTICSELEC,
				null);

		SerieMovieList comedyList = new SerieMovieList();

		comedyList.addContent(new AudioVisualContent("Break", comedy.getGender(), 13,
				"Despues de un grave accidente, Lucie teme ver roto el sueño de su vida: "
						+ "convertirse en bailarina. Se va de un barrio bueno a las afueras en busca del padre que nunca ha conocido. AllA conoce a Vincent, "
						+ "un ex bailarin que extrañamente ha sacrificado su pasion. Empujado por Malik, su complice de siempre, accede a entrenarla y le hace "
						+ "descubrir un nuevo estilo de baile, el break. Viniendo de dos mundos diferentes, Lucie y Vincent participaron en un dueto apasionado de baile y sentimientos.",
				96, ResourcesPath.BREAK, "Marc Fouchard", ContentType.FILM, 2018));

		comedyList.addContent(new AudioVisualContent("Los Miembros de La Familia", comedy.getGender(), 16,
				"Lucas un adolescente obsesionado con su cuerpo, y su hermana mayor Gilda (Laila Maltz), "
						+ "con unas creencias misticas muy arraigadas, deciden viajar a una ciudad costera casi desierta, para tratar de cumplir los ultimos deseos de su difunta madre y arrojar sus restos al mar. "
						+ "Cuando parece que solo les queda volver a casa y enterrar en lo mas profundo ese horrible capitulo de sus vidas, se ven atrapados por una huelga de autobuses. "
						+ "Sera entonces cuando Lucas y Gilda emprenderan un viaje de retorno a su adolescencia, tragicamente arrebatada por la perdida de su madre, "
						+ "y enfrentar algunas ambiguedades de la vida, tales como la vida, la muerte y la salud fisica y mental.",
				86, ResourcesPath.LOSMIENMBROSFAMILIA, "Mateo Bendesky", ContentType.FILM, 2019));
		comedyList.addContent(new AudioVisualContent("Survival Skills", comedy.getGender(), 18,
				"Jim, un policia novato atrapado en un video de entrenamiento de la policia de mediados de los 80 por un narrador omnipotente y malicioso (Keach)."
						+ " Durante la proxima hora, vamos a seguir a Jim en su primer año como oficial de policia. Llevara a cabo paradas de trafico, hara arrestos, "
						+ "interactuara con su comunidad y se saldra de control, poniendo en peligro a las personas que mas ama. ¡Buena suerte, Jim!",
				86, ResourcesPath.SURVIVALSKILLS, "Quinn Armstrong", ContentType.FILM, 2020));
		comedyList.addContent(new AudioVisualContent("Little Dog", comedy.getGender(), 18,
				"El boxeador profesional Tommy ¡Little Dog! Ross, el favorito para ganar un cinturon de campeonato, "
						+ "tiene un colapso de clase mundial en medio de la pelea y sale del ring. Nos volvemos a encontrar con el cinco años despues, viviendo una vida de autodestruccion general, "
						+ "cuando lo capturan en un video en una pelea de bar, lo que lleva al viejo rival Rico Havoc St. George a desafiarlo a una revancha por el titulo."
						+ " Tommy lucha por quitarse de la cabeza el ruido de su ferrea familia para poder tomar la decision de volver al ring o no.",
				0, ResourcesPath.LITTLEDOG, "Joel Thomas Hynes", ContentType.SERIE, 2018));
		comedyList.addContent(new AudioVisualContent("El Vato", comedy.getGender(), 14,
				"El cantante mexicano El Vato y sus amigos intentan triunfar en el traicionero y seductor mundo musical de Los Angeles, "
						+ "California. El Vato te ofrece una oportunidad unica en tu vida para grabar el proximo gran album que te dara el salto a la fama, "
						+ "pero a cambio tienes que dejar tu vida simple en Sonora para vivir bajo el brillo de las luces de Los angeles e intentarlo. "
						+ "para mantenerse enfocado en medio de todas las tentaciones de la gran ciudad. Para El Vato, es hora de saltar al estrellato o ir a casa.",
				0, ResourcesPath.ELVATO, "Jorge Dorantes, Endemol Shine Group", ContentType.SERIE, 2016));

		this.categoryList.addCategoryAndContent(GenderList.COMEDY, ResourcesPath.COMEDY,
				ResourcesPath.COMEDYSELEC, comedyList);

		SerieMovieList actionList = new SerieMovieList();

		actionList.addContent(new AudioVisualContent("Echo Boomers", action.getGender(), 16,
				"Un recien graduado universitario, Lance Zutterland (Schwarzenegger), "
						+ "deja la escuela endeudado y se da cuenta de que todo por lo que habia trabajado se basaba en una mentira. Cuando se ve involucrado en una operacion criminal clandestina, "
						+ "encuentra a sus compañeros luchando contra el sistema, robando a los ricos para darselo... a ellos mismos. Sin nada que perder, dejan un rastro de destruccion,"
						+ " pero con la policia acercandose, las tensiones aumentan y Lance pronto descubre que esta en un callejon sin salida.",
				94, ResourcesPath.ECHOBOOMERS, "Seth Savoy", ContentType.FILM, 2020));
		actionList.addContent(new AudioVisualContent("Escape and Evasion", action.getGender(), 18,
				"Tras perder a sus hombres en Burma, "
						+ "un soldado solitario regresa a casa en busca de consuelo. Escondiendo un oscuro secreto y viendose perseguido por un incansable periodista, "
						+ "se ve forzado a enfrentarse a los fantasmas de su pasado una vez mÃ¡s.",
				92, ResourcesPath.ESCAPEEVASION, "Storm Ashwood", ContentType.FILM, 2019));
		actionList.addContent(new AudioVisualContent("Skyfire", action.getGender(), 0,
				"En un centro vacacional construido en la isla volcanica de Tanhuo. "
						+ "A pesar de los avisos de los sismologos, su dueño sigue adelante con el plan de abrir el centro. Por supuesto, "
						+ "la catastrofe no se hace esperar y el volcan entra en erupcion. La joven vulcanologa Meng y su padre tendran que superar los problemas de su pasado para salvar el mayor"
						+ " numero de vidas posible en una carrera contrarreloj a traves de la abrasadora devastacion de lava y cenizas.",
				97, ResourcesPath.SKYFIRE, "Simon West", ContentType.FILM, 2019));
		actionList.addContent(new AudioVisualContent("Sangre de Zeus", action.getGender(), 16,
				"Sangre de Zeus, es una serie anime que cuenta la historia de un joven hombre que, "
						+ "repudiado por su propio pueblo, descubre que es el hijo ilegitimo de Zeus. El, por sus propios medios, puede salvar tanto al cielo como a la Tierra, "
						+ "pero para ello debe sobrevivir a la terrible ira de una diosa que le quiere muerto y a las monstruosas fuerzas malignas con las que ella se alia.",
				0, ResourcesPath.SANGREZEUS, "Charley Parlapanides, Vlas Parlapanides", ContentType.SERIE, 2020));
		actionList.addContent(new AudioVisualContent("Sleepy Hollow", action.getGender(), 12,
				"Ichabod Crane es resucitado, "
						+ "traido a la epoca presente y obligado a desenredar un misterio que data de la epoca de los padres fundadores del pais. Con el ha revivido tambien el infame Jinete Sin Cabeza, "
						+ "el peligroso asesino que aterrorizaba Sleepy Hollow en su epoca y que parece haber vuelto a las andadas. Ligado a el por un hechizo de sangre lanzado en epoca de la Revolucion americana, "
						+ "Ichabod se dara cuenta rapidamente que detener al jinete es solo el principio, ya que el malvado jinete al que persigue es tan solo el primero de los cuatro jinetes del Apocalipsis.",
				0, ResourcesPath.SLEEPYHOLLOW, "Washington Irving, Andrew Kevin Walker", ContentType.SERIE, 2013));

		this.categoryList.addCategoryAndContent(GenderList.ACTION, ResourcesPath.ACTION,
				ResourcesPath.ACTIONSELEC, actionList);

		SerieMovieList romaticList = new SerieMovieList();

		romaticList.addContent(new AudioVisualContent("Crepusculo", romantic.getGender(), 16,
				"Bella Swan, una chica de diecisiete años, deja Phoenix, Arizona y se muda a Forks, un pequeño pueblo ubicado en la PenÃ­nsula OlÃ­mpica del estado de Washington, para vivir con su padre, Charlie, el jefe de policia de la ciudad. Su madre, Renee, se volvia a casar con Phil, un jugador de beisbol de ligas menores cuya carrera a menudo mantiene a la pareja en el camino.",
				126, ResourcesPath.CREPUSCULO, " Catherine Hardwicke", ContentType.FILM, 2008));
		romaticList.addContent(new AudioVisualContent("The Twilight Saga: Luna nueva", romantic.getGender(), 16,
				"En su decimoctavo cumpleaños, Bella Swan despierta de un sueño en el que es una anciana y Edward Cullen, su novio vampiro inmortal, es siempre joven. A pesar de la falta de entusiasmo de Bella, la familia de Edward organiza una recepcion de cumpleaÃ±os para ella en su residencia. Mientras desenvuelve un regalo, se corta con el papel. El hermano adoptivo de Edward, Jasper, se siente abrumado por el olor de la sangre e intenta atacarla, pero se contiene. Creyendo que el y su familia estan poniendo la vida de Bella en peligro, Edward termina su relacion y los Cullen abandonan Forks.",
				130, ResourcesPath.LUNANUEVA, "Chris Weitz", ContentType.FILM, 2009));
		romaticList.addContent(new AudioVisualContent("The Twilight Saga: Eclipse", romantic.getGender(), 16,
				"Riley Biers es atacado por Victoria, mientras ella estÃ¡ fuera creando un ejercito conjunto de vampiros neÃ³fitos para destruir a Bella Swan. En Forks, Edward Cullen y Bella deben discutir acerca de las complicaciones de convertirse en un vampiro inmortal aunque Edward se niega a darle la inmortalidad hasta que estan casados y hasta que haya tenido diversas experiencias humanas. Mientras que Charlie Swan esti investigando la desaparicion de Riley Biers, Edward sospecha que su desaparicion fue causada por los vampiros neofitos.",
				131, ResourcesPath.ECLIPSE, "David Slade", ContentType.FILM, 2010));
		romaticList.addContent(new AudioVisualContent("The Twilight Saga: Breaking Dawn Part 1", romantic.getGender(),
				16,
				"Jacob Black se encuentra desaparecido por no querer enfrentar el hecho de que su mejor amiga se va a casar. Bella y Edward Cullen celebran su boda organizada por Alice, sin embargo Jacob regresa en Ãºltimo momento para la boda, para despedirse de ella preguntÃ¡ndole si esa misma noche sera su cambio pero Bella le dice que sera despues de tener intimidad con Edward, a lo cual Jacob se enfada porque podria ser peligroso para ella. ",
				124, ResourcesPath.BREAKINGDAWNPART1, "Bill Condon", ContentType.FILM, 2011));
		romaticList.addContent(new AudioVisualContent("The Twilight Saga: Breaking Dawn Part 2", romantic.getGender(),
				16,
				"Tras el nacimiento de Renesmee (Mackenzie Foy) y la transformacion de Bella (Kristen Stewart) en vampiro, esta trata de acoplarse poco a poco a su nueva vida inmortal y aceptar el hecho de que Jacob (Taylor Lautner) se imprima de Renesmee y que le es imposible separarse de ella. Conforme pasan los dias, la familia Cullen se preocupa por el rapido crecimiento de la pequeña, temiendo que sus dias lleguen a su fin de manera precipitada.",
				115, ResourcesPath.BREAKINGDAWNPART2, "Bill Condon", ContentType.FILM, 2012));
		romaticList.addContent(new AudioVisualContent("The Notebook", romantic.getGender(), 16,
				"La historia se remonta al verano de 1940 en Seabrook, Carolina del Sur. Allie Hamilton (Rachel McAdams) es una chica de una familia rica que pasa el verano en Seabrook.",
				124, ResourcesPath.THENOTEBOOK, " Nick Cassavetes", ContentType.FILM, 2004));

		this.categoryList.addCategoryAndContent(GenderList.ROMANTIC, ResourcesPath.ROMANTIC,
				ResourcesPath.ROMANTICSELEC, romaticList);

		SerieMovieList fictionList = new SerieMovieList();

		fictionList.addContent(new AudioVisualContent("Proyecto Geminis", fiction.getGender(), 13,
				"Un asesino a sueldo, demasiado mayor, decide retirarse. Pero esto no le va a resultar tan facil,"
						+ " pues tendrs que enfrentarse a un clon suyo, mucho mss joven..",
				117, ResourcesPath.PROYECTOGEMINIS, "Ang Lee", ContentType.FILM, 2019));
		fictionList.addContent(new AudioVisualContent("Tenet", fiction.getGender(), 14,
				"Una accion epica que gira en torno al espionaje internacional, los viajes en el tiempo y la evolucion, "
						+ "en la que un agente secreto debe prevenir la Tercera Guerra Mundial..",
				150, ResourcesPath.TENET, "Christopher Nolan", ContentType.FILM, 2020));
		fictionList.addContent(new AudioVisualContent("Valerian y la Ciudad de los Mil Planetas", fiction.getGender(),
				15,
				"En el siglo XXVIII, los agentes terricolas Valerian y Laureline son enviadas por el ministro de Defensa a explorar un nuevo mundo"
						+ " que esta al borde de una guerra civil para comprobar si son una amenaza potencial contra la Tierra.",
				137, ResourcesPath.VALERIANCIUDADMILPLANETAS, "Luc Besson", ContentType.FILM, 2017));
		fictionList.addContent(new AudioVisualContent("Dark", fiction.getGender(), 16,
				"La desaparicion de dos niños muestra los vinculos entre cuatro familias y expone el pasado de una pequeña ciudad.",
				51, ResourcesPath.DARK, "N/A", ContentType.SERIE, 2017));
		fictionList.addContent(new AudioVisualContent("Arrow", fiction.getGender(), 15,
				"Cuando Oliver Queen, un billonario mujeriego, que se presumia habia fallecido, regresa a casa a la ciudad Starling, luego de cinco años de quedar atrapado en una isla remota en el Pacifico, "
						+ "El esconde los cambios creados por la experiencia en si mismo, mientras busca la reconciliacion con su ex Laurel.",
				42, ResourcesPath.ARROW, "N/A", ContentType.SERIE, 2012));

		this.categoryList.addCategoryAndContent(GenderList.FICTION, ResourcesPath.FICTION,
				ResourcesPath.FICTIONSELEC, fictionList);

		SerieMovieList adventureList = new SerieMovieList();

		adventureList.addContent(new AudioVisualContent("Kung Fu Panda", adventure.getGender(), 8,
				"En el Valle de la Paz, una tierra de la Antigua China habitada por animales antropom�rficos, Po es fan�tico del kung fu e idolatra a los Cinco Furiosos: Tigresa, Mono, Grulla, V�bora y Mantis, un grupo de maestros de kung fu entrenados por el Maestro Shifu. Sin embargo, Po no puede perseguir su sue�o de aprender kung fu mientras ayuda a su padre adoptivo, el Sr. Ping el ganso, en su restaurante de fideos.",
				95, ResourcesPath.KUNGFYPANDA, "Mark Osborne y John Wayne Stevenson.", ContentType.FILM, 2008));
		adventureList.addContent(new AudioVisualContent("Kung Fu Panda 2", adventure.getGender(), 8,
				"Mucho antes de los acontecimientos de la primera pelicula, Lord Shen, el hijo de los pavos reales que gobernaban la ciudad de Gongmen, decidio usar el poder de los fuegos artificiales como un arma para conquistar China entera. ",
				92, ResourcesPath.KUNGFYPANDA2, "Jennifer Yuh Nelson", ContentType.FILM, 2011));
		adventureList.addContent(new AudioVisualContent("Kung Fu Panda 3", adventure.getGender(), 8,
				"En el Mundo de Los Espiritus, El Maestro Oogway medita hasta que es interrumpido por Kai, un yak y enemigo de Oogway y los 2 inician un combate, Kai le revela que ha tomado el chi de todos los maestros del Kung fu y que planea tomar el suyo para regresar al mundo de los vivos, y finalmente logra agarrar a Oogway y le roba su chi no antes de que Oogway le diga a Kai que El Guerrero Dragon lo derrotara. ",
				95, ResourcesPath.KUNGFYPANDA3, "Jennifer Yuh Nelson", ContentType.FILM, 2016));
		adventureList.addContent(new AudioVisualContent("Indiana Jones y el templo maldito", adventure.getGender(), 16,
				"La historia comienza en Shanghai en el año de 1935. Cuando la cantante Wilhelmina Willie Scott termina de cantar en el Club Obi Wan una version en mandaron de la cancion \"Anything Goes\", Indy y el dueño del club, Lao Che, tienen asuntos que atender. Jones ha recuperado las cenizas del Nuhachi, el primer emperador de la dinastia mancha de China, y a cambio del valioso objeto Lao le entregara el «Ojo del Pavorreal», un enorme diamante.",
				118, ResourcesPath.INDIANAJONESELTEMPLOMALDITO, " Steven Spielberg", ContentType.FILM, 1984));
		adventureList.addContent(new AudioVisualContent("La momia", adventure.getGender(), 16,
				"En Tebas, Egipto, alrededor del aÃ±o 1290 A.C., el sumo sacerdote Imhotep mantiene una relacion con Anck-su-Namun, la concubina del faraon Seti I (a ningun otro hombre le era permitido tocarla y como precaucion, la habian cubierto con pintura dorada y negra).",
				111, ResourcesPath.LAMOMIA, " Stephen Sommers", ContentType.FILM, 1999));
		adventureList.addContent(new AudioVisualContent("Piratas del Caribe: la maldicion del Perla Negra",
				adventure.getGender(), 16,
				"Elizabeth Swann tenia doce añs cuando navegaba junto a su padre, el noble gobernador Weatherby Swann, y el oficial James Norrington rumbo a Port Royal desde Inglaterra. ",
				143, ResourcesPath.PIRATASCARIBELAMALDICIONPERLANEGRA, "Gore Verbinski", ContentType.FILM, 2003));

		this.categoryList.addCategoryAndContent(GenderList.ADVENTURE, ResourcesPath.ADVENTURE,
				ResourcesPath.ADVENTURESELEC, adventureList);

		SerieMovieList terrorList = new SerieMovieList();

		terrorList.addContent(new AudioVisualContent("El conjuro", terror.getGender(), 16,
				"A principios de los años 70, Ed y Lorrain Warren, reputados investigadores de fenomenos paranormales,"
						+ " se enfrentan a una entidad demoniaca al intentar ayudar a una familia que esta siendo aterrorizada por una presencia oscura en su aislada granja.",
				112, ResourcesPath.ELCONJURO, "James Wan", ContentType.FILM, 2013));
		terrorList.addContent(new AudioVisualContent("Z", terror.getGender(), 16,
				"Una familia se encuentra aterrorizada por el amigo imaginario de su hijo de ocho años...", 83,
				ResourcesPath.Z, "Brandon Christensen", ContentType.FILM, 2019));
		terrorList.addContent(new AudioVisualContent("El titere", terror.getGender(), 17,
				"Un joven viudo (Kwanten) regresa a su hogar para investigar el asesinato de su mujer. AllA descubre la leyenda de Mary Shaw, una ventrilocua que pidio ser enterrada junto a sus 101 "
						+ "\"muñecos\". Uno de ellos parece haber vuelto de la tumba, y no precisamente con buenas intenciones... De los creadores de \"Saw\"..",
				89, ResourcesPath.ELTITERE, "James Wan", ContentType.FILM, 2007));
		terrorList.addContent(new AudioVisualContent("American Horror Story", terror.getGender(), 17,
				"Sigue a la familia Harmon: Ben de profesion psiquiatra, su esposa Vivien, y su hija adolescente Violet, "
						+ "quienes se mudan de Boston a Los angeles despues de que Vivien tenga un aborto involuntario y Ben una aventura con una ...",
				42, ResourcesPath.AMERICANHORRORSTORIES, "Ryan Murphy, Brad Falchuk", ContentType.SERIE, 2011));
		terrorList.addContent(new AudioVisualContent("The Walking Dead", terror.getGender(), 18,
				"\"The Walking Dead\" esta ambientada en un futuro apocaliptico con la Tierra devastada por el efecto de un cataclismo, "
						+ "que ha provocado la mutacion en zombies de la mayor parte de los habitantes del planeta. La serie, explora las dificultades de los protagonistas para sobrevivir en un mundo poblado por el horror,"
						+ " asi como las relaciones personales que se establecen entre ellos, en ocasiones tambien una amenaza para su supervivencia..",
				60, ResourcesPath.THEWALKINGDEAD, "N/A", ContentType.SERIE, 2010));

		this.categoryList.addCategoryAndContent(GenderList.TERROR, ResourcesPath.TERROR,
				ResourcesPath.TERRORSELEC, terrorList);

	} // Fin de loadCategoryNodes

	public Category getCategoryInUse() {
		return categoryInUse;
	}

	public void setCategoryInUse(Category categoryInUse) {
		this.categoryInUse = categoryInUse;
	}

	public CategoryList getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(CategoryList categoryList) {
		this.categoryList = categoryList;
	}

} // Fin de clase
