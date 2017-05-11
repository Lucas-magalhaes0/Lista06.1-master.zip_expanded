final class Banco {
	
	//hab e dano
	static final String [] nomeHab = {"Tapa", "Soco", "Abraço"};
	static final  String[] tipoHab = {"Pedra", "Papel", "Tesoura"};
	static final int[]	atkPrioridade = {1, 2, 2};
	static final int [] valAtk = {60, 40, 50};
	static  int indexHabAtk = 0;

	//pokemons
	static int v[] = {0,1,2};
	static final Pokemon [] poke =
			{
					new Pokemon("Pikachu","Pedra",100,40,30,120,v),
					new Pokemon("Pipilupi","Tesoura",120,40,30,120,v)
					
			};
	static int indexPoke = 0;
	
	//itens
	static final Item [] itens = {
			new Item("Pocao",25)
	};
	static int indexItem = 0;
	
	
	public static void addHabAtk (String nome, int valAtk, String tipo, int prioridade) {
		if (indexHabAtk > 100) return;
		Banco.atkPrioridade[indexHabAtk] = prioridade;
		//Banco.nomeHab[indexHabAtk] = nome;
		Banco.tipoHab[indexHabAtk] = tipo;
		Banco.valAtk[indexHabAtk++] = valAtk;	
		
	} //
	
	
	public static void addPoke (String nome, String tipo, int [] Golpes, int pVida, int pAtaque, int pDefesa, int pVelocidade) {
		if (indexPoke > 100) return;
		
		Pokemon e = new Pokemon(nome, tipo, pVida, pAtaque, pDefesa, pVelocidade, Golpes);
		
		
		poke[indexPoke++] = e;
	}
	
	public void addItens (String nomeItem, int valCura) {
		if (indexItem > 100) return;
		
		Item e = new Item(nomeItem, valCura);
		
		Banco.itens[indexItem++] = e;
	}
	
	public static void  main (String [] args) {
		
	}
	
}
