package backGroundProcesses;

/**
 * 
 */

/**
 * @author chrisubuntu
 * 
 */
public class CompleteStackFinal extends CompleteStack implements
		Stack<PlayerNode> {
	
	protected int size;
	protected static final boolean isPPR = Modifiers.ifIsPPR();
	protected static final boolean isKeeper = Modifiers.ifIsKeeper();
	private PlayerNode curr, head;
	private PlayerNode lastCompleteNode = new FinalCompleteNode();
	

	private int sortTO;
	public int availSlots;

	public CompleteStackFinal() {
		// TODO Auto-generated constructor stub
		this.size = 0;
		this.head = this.Finalhead;
	}

	@Override
	public void push(PlayerNode curr2) {

		// TODO Auto-generated method stub
		if (this.isEmpty())
			throw new IllegalArgumentException();

		this.lastCompleteNode.next = curr2;
		this.lastCompleteNode = this.lastCompleteNode.next;
		this.Finalhead.prev = this.lastCompleteNode;
		this.size++;

	}

	@Override
	public PlayerNode pop() throws EmptyCompleteStackException {
		// If list not empty, removes current top node, re-links
		// current list head.previous to head.previous.previous,
		// then links head.previous to head;
		if (this.isEmpty())
			throw new EmptyCompleteStackException("This list of"
					+ "	available players is empty. " + "\n"
					+ " No players to select.");

		PlayerNode temp;

		temp = this.lastCompleteNode;
		this.lastCompleteNode = temp.prev;
		this.lastCompleteNode.next = temp.next;
		this.size--;

		return this.lastCompleteNode;
	}

	@Override
	public PlayerNode peek() throws EmptyCompleteStackException {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new EmptyCompleteStackException("This stack is empty.");
		}
		return lastCompleteNode;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.size == 0)
			return true;

		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean contains(String toRemove) {
		// TODO Auto-generated method stub
		PlayerNode current = this.head;
		while (current.next != this.head) {
			if (toRemove.equalsIgnoreCase(current.name)) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	public void removePlayer(String toRemove) {
		// TODO Auto-generated method stub
		PlayerNode next = new FinalCompleteNode();
		PlayerNode prev = new FinalCompleteNode();
		if (this.contains(toRemove)) {
			curr = this.Finalhead;
			next = curr.next;
			prev = curr.prev;
			while (next != this.Finalhead) {
				if (curr.next.name.equalsIgnoreCase(toRemove)) {
					prev.next = next.next;
					next.prev = prev.prev;

				}

				curr = curr.next;
				next = next.next;
				prev = prev.next;
			}

		}
	}

	public CompleteStackFinal sort(PlayerNode finalhead, int sortMid) {
		// TODO Auto-generated method stub
		CompleteStackFinal right = new CompleteStackFinal();
		CompleteStackFinal left = new CompleteStackFinal();

		if (finalhead == null)
			throw new IllegalArgumentException();

		PlayerNode curr = finalhead;
		int i = 1;
		while (i <= sortMid) {
			right.push(curr);
			curr = curr.next;
			i++;
		}
		while (sortTO + 1 < this.size) {
			left.push(curr);
			curr = curr.next;
			sortTO++;
		}
		right = mergeSort(right, copy(right));
		left = mergeSort(left, copy(left));

		return mergeSort(right, left);
	}

	public void sort2() {
		PlayerNode temp;
		PlayerNode player;
		PlayerNode nextPlayer;

		if (this.isEmpty())
			System.out.println("This list is empty.");

		player = this.Finalhead.next;
		nextPlayer = player.next;
		double firstPlayerAVG2 = player.avgRank * 100;
		double secondPlayerAVG2 = nextPlayer.next.avgRank * 100;
		String firstPlayerAVG1 = String.valueOf(firstPlayerAVG2);
		String secondPlayerAVG1 = String.valueOf(secondPlayerAVG2);
		int firstPlayerAVG = Integer.parseInt(firstPlayerAVG1);
		int secondPlayerAVG = Integer.parseInt(secondPlayerAVG1);

		if (player.next == this.Finalhead) {
			System.out.println("List is already sorted.");
		}
		while (player != this.Finalhead) {
			if (firstPlayerAVG < secondPlayerAVG) {
				temp = player;
				temp.next = nextPlayer.next;
				temp.prev = nextPlayer;
				nextPlayer.next = temp;
				nextPlayer.prev = temp.prev;
				player = temp;

			}
			player = player.next;
		}
	}

	public void sort3(PlayerNode next) {
		PlayerNode temp;
		PlayerNode player;
		PlayerNode nextPlayer;

		if (next == null)
			System.out.println("This list is empty.");

		if (next.next != this.Finalhead) {
			player = this.Finalhead.next;
			nextPlayer = player.next;
			double firstPlayerAVG2 = player.avgRank * 100;
			double secondPlayerAVG2 = nextPlayer.next.avgRank * 100;
			String firstPlayerAVG1 = String.valueOf(firstPlayerAVG2);
			String secondPlayerAVG1 = String.valueOf(secondPlayerAVG2);
			int firstPlayerAVG = Integer.parseInt(firstPlayerAVG1);
			int secondPlayerAVG = Integer.parseInt(secondPlayerAVG1);

			if (firstPlayerAVG < secondPlayerAVG) {
				temp = player;
				temp.next = nextPlayer.next;
				temp.prev = nextPlayer;
				nextPlayer.next = temp;
				nextPlayer.prev = temp.prev;
				player = temp;

			}
			sort3(player.next);
		}
	}

	public static CompleteStackFinal copy(CompleteStackFinal toCopy) {
		CompleteStackFinal CopyOfNewStack = new CompleteStackFinal();

		if (toCopy.isEmpty())
			System.out.println("No list to copy.");

		PlayerNode curr = toCopy.Finalhead.next;

		while (curr.next != toCopy.Finalhead) {
			CopyOfNewStack.push(curr);
		}
		return CopyOfNewStack;
	}

	public CompleteStackFinal mergeSort(CompleteStackFinal newList1,
			CompleteStackFinal newList2) {
		// TODO Auto-generated method stub

		if (newList1.isEmpty())
			System.out.println("First List is empty.");

		if (newList2.isEmpty())
			System.out.println("Second List is empty.");

		if (newList1.isEmpty() || newList2.isEmpty())
			return null;

		CompleteStackFinal a = newList1, b = newList2;
		PlayerNode curr = a.Finalhead.next;
		PlayerNode curr1 = b.Finalhead.next;
		while (curr.next != newList1.Finalhead
				|| curr1.next != newList2.Finalhead) {
			a.Finalhead.next = (curr.avgRank > curr1.avgRank ? curr : curr1);
			curr = curr.next;
			curr1 = curr1.next;
		}

		return this;
	}

	public String toString() {

		PlayerNode curr = this.Finalhead.next;

		String result = "\n" + "|**|**|**|**|**|**|**|**|**|" + "\n\n";

		while (curr.next != curr) {

			result += ("Player Name: " + curr.name + "\n" + "Pos: " + curr.pos
					+ "\n" + "AVG Rank: " + curr.avgRank + "\n" + "Team: "
					+ curr.team + "\n" + "AVG Pts Last 2: " + curr.avgPtsLast2
					+ "\n" + "Projected Depth: " + curr.projDepth + "\n"
					+ "Inj Risk: " + curr.injRisk + "\n" + "Num Games Missed: "
					+ curr.numGamesMiss + "\n"
					+ "Fantasy Playoff Sched. Rank: " + curr.ffSchedRank
					+ "\n\n" + "|**|**|**|**|**|**|**|**|**|" + "\n\n");

			curr = curr.next;
		}

		return result;
	}

}
/**
	 * 
	 */
