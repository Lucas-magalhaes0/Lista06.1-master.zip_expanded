class EventSet {
	private TurnoDaBatalha[] jogador1 = new TurnoDaBatalha[100];
	private TurnoDaBatalha[] jogador2 = new TurnoDaBatalha[100];
	private int index = 0;
	private int index2 = 0;
	private int i = 0;
	private int j = 0;
	public void addJogador1(TurnoDaBatalha c){
		jogador1[index++] = c;
	}
	public void addJogador2(TurnoDaBatalha c){
		jogador2[index2++] = c;
	}
	public TurnoDaBatalha proxTurnoJogador1(){
		return jogador1[i++]; 
	}
	public TurnoDaBatalha proxTurnoJogador2(){
		return jogador2[j++];
	}
	public boolean comparaPrioridades(){
		int h;
		h = jogador1[i-1].prioridade - jogador2[j-1].prioridade;
		if(h>=0){
			return true;
		}
		else return false;
	}
}


public class EventBattle {
	EventSet Luta = new EventSet();
	public void addTurno1(TurnoDaBatalha c){ Luta.addJogador1(c); }
	public void addTurno2(TurnoDaBatalha c){ Luta.addJogador2(c); }
	public void escolheAcao1(Treinador a, Treinador b){
		BatalhaPokemon h;
		h = new BatalhaPokemon();
		if(a.pokes[0].pVida > 40){
			addTurno1(h. new Atacar(2));
			return;
		}
		if(a.pokes[0].pVida < 15){
			addTurno1(h. new UsarItem());
			return;
		}
		if(a.pokes[0].pVida <= 40 && a.pokes[0].pVida >= 15){
			addTurno1(h. new TrocarPokemon(1));
			return;
		}
		
	}
	public void escolheAcao2(Treinador a, Treinador b){
		BatalhaPokemon h;
		h = new BatalhaPokemon();
		if(a.pokes[0].pVida > 40){
			addTurno2(h. new Atacar(2));
			return;
		}
		if(a.pokes[0].pVida < 15){
			addTurno2(h. new UsarItem());
			return;
		}
		if(a.pokes[0].pVida <= 40 && a.pokes[0].pVida >= 15){
			addTurno2(h. new TrocarPokemon(1));
			return;
		}
		
	}
	public void run(Treinador a, Treinador b){
		TurnoDaBatalha e1,e2;
		while(a.estaNoJogo() && b.estaNoJogo()){
			escolheAcao1(a,b);
			escolheAcao2(b,a);
			e1 = Luta.proxTurnoJogador1();
			e2 = Luta.proxTurnoJogador2();
			if(Luta.comparaPrioridades()){
				if(e1.atacou)
					a = e1.action(a, b);
				else
					b = e1.action(a, b);
				e1.descricao(a, b);
				if(!b.estaNoJogo())
					break;
				if(e2.atacou)
					a = e2.action(b, a);
				else 
					b = e2.action(b, a);
				e2.descricao(b, a);
				if(!a.estaNoJogo())
					break;
			}
			else {
				if(e2.atacou)
					a = e2.action(b, a);
				else
					b = e2.action(b, a);
				e2.descricao(b, a);
				if(!a.estaNoJogo())
					break;
				if(e1.atacou)
					b = e1.action(a, b);
				else
					a = e1.action(a, b);
				e1.descricao(a, b);
				if(!b.estaNoJogo())
					break;
			}
			if(a.pokes[0].pVida == 0)
				for (int i = 1; i <= a.getPokeN(); i++) {
					if (a.pokes[i].isAlive) {
						a.alteraPokePrincipal(i);
						System.out.println("O jogador " + a.nome + " lançou o Pokemon " + a.pokes[i].nome + "!");
						break;
					}
				}
		}
			if(b.pokes[0].pVida == 0)
				for (int i = 1; i <= b.getPokeN(); i++) {
					if (b.pokes[i].isAlive) {
						b.alteraPokePrincipal(i);
						System.out.println("O jogador " + b.nome + " lançou o Pokemon " + b.pokes[i].nome + "!");
						break;
					}
				}
		if(!b.estaNoJogo())
			System.out.println("O jogador "+ b.nome + " perdeu!");
		else
			System.out.println("O jogador "+ a.nome + " perdeu!");
	}
}