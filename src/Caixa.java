
import java.util.*;

class Caixa {
	static Scanner entry = new Scanner(System.in);
	static Stack<Integer> pilha = new Stack<Integer>();
	static int linhaBox;
	static int pilhaBox;

	public static void main(String[] args) {
		int caixas, pilhas;

		while (entry.hasNextInt()) {
			caixas = entry.nextInt();
			pilhas = entry.nextInt();
			if (pilhas == 0) {
				break;	
			}

			capturaPilha(pilhas);

			int esquerda = esquerda();
			int direita = direita(pilhas);
			
			
			if(esquerda>direita){
				System.out.println(direita);
			}else{
				System.out.println(esquerda);
			}
			pilha.clear();
		}
	}

	public static void capturaPilha(int pilhas) {
		linhaBox = 0;
		pilhaBox = 0;
		for (int i = 0; i < pilhas; i++) {
			pilha.push(entry.nextInt());
			for (int j = 0; j < pilha.get(i); j++) {
				int caixa = entry.nextInt();
				if (caixa == 1) {
					linhaBox = j + 1;
					pilhaBox = i;
				}
			}
		}
	}
	
	public static int direita(int pilhas) {
		int direita = pilha.get(pilhaBox) - linhaBox;
		
		for (int i = pilhaBox + 1; i < pilhas; i++) {
			if (pilha.get(i) >= linhaBox) {
				direita += pilha.get(i) - linhaBox + 1;
			} else {
				break;
			}
		}
		return direita;
	}

	public static int esquerda() {
		int esquerda = pilha.get(pilhaBox) - linhaBox;
		
		for (int i = pilhaBox - 1; i >= 0; i--) {
			if (pilha.get(i) >= linhaBox) {
				esquerda += pilha.get(i) - linhaBox + 1;
			} else {
				break;
			}
		}
		return esquerda;
	}

}