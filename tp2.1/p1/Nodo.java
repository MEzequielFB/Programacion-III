public class Nodo {
    private Integer value;
	private Nodo left;
	private Nodo right;

	public Nodo(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

    public boolean isExternalNode() {
        if (this.left == null && this.right == null) {
            return true;
        }
        return false;
    }

	public Nodo getLeft() {
		return this.left;
	}

	public void setLeft(Nodo left) {
		this.left = left;
	}

	public Nodo getRight() {
		return this.right;
	}

	public void setRight(Nodo right) {
		this.right = right;
	}

	public Integer getValue() {
		return this.value;
	}

    @Override
    public String toString() {
        return this.value + "";
    }
}