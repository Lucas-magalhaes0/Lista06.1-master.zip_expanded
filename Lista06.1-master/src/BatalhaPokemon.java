
public class BatalhaPokemon extends EventBattle {
	 class Atacar extends TurnoDaBatalha{
		 atacou = true;
		 int ataqueIndice;
		Atacar(int i){
			super(Banco.atkPrioridade[i]);
			ataqueIndice = i;
		}
		public Treinador action(Treinador a, Treinador b){
			b.pokes[0].pVida -= Banco.valAtk[ataqueIndice];
			if(b.pokes[0].pVida <= 0) {
				b.pokes[0].pVida = 0;
				b.pokes[0].isAlive = false;
			}
			return b;
		}
		public void descricao(Treinador a, Treinador b){
			System.out.println("O "+ a.pokes[0].nome +" usou "+ Banco.nomeHab[ataqueIndice] + " no "+b.pokes[0].nome);
		}
	}
	 class UsarItem extends TurnoDaBatalha{
		boolean atacou = false;
		UsarItem(){
			super(3);
		}
		public Treinador action(Treinador a, Treinador b){
			a.useItem(0);
			return a;
		}
		public void descricao(Treinador a, Treinador b){
			System.out.println("O treinador"+a.nome + "curou seu pokemon!");
		}
	}
	 class TrocarPokemon extends TurnoDaBatalha{
		 boolean atacou = false;
		 int index;
		 TrocarPokemon(int i){
			 super(3);
			 index = i;
		 }
		 public Treinador action(Treinador a, Treinador b){
			 a.alteraPokePrincipal(index);
			 return a;
		 }
		 public void descricao(Treinador a, Treinador b){
			 System.out.println("O treinador"+a.nome+"trocou o seu pokemon pelo"+a.pokes[0].nome);
		 }
	 }
}
