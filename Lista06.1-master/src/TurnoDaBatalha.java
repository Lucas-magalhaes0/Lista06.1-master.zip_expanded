
abstract public class TurnoDaBatalha {
	int prioridade;
	protected boolean atacou = true;
	TurnoDaBatalha(int i){
		prioridade = i;
	}
	abstract public Treinador action(Treinador a, Treinador b);
	abstract public void descricao(Treinador a, Treinador b);
}
