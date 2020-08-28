package cc.retzlaff.timon;

public class Vector2{
	private float x;
	private float y;
	public Vector2 (float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Vector2(Vector2 vector2) {
		this.x = vector2.x;
		this.y = vector2.y;
	}

	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}

	public static float generateRandomFloatInRange(float min, float max) {
		return (float) (Math.random() * (max - min) + min);
	}

	public static Vector2 generateRandomFloatInRange(float minY, float minX, float maxY, float maxX) {
		float x = generateRandomFloatInRange(minX, maxX);
		float y = generateRandomFloatInRange(minY, maxY);
		return new Vector2(x, y);
	}

	public void addX(float deltaX) {
		this.x += deltaX;
	}

	public void addY(float deltaY) {
		this.y += deltaY;
	}

	public void multX(float factor) {
		this.x *= factor;
	}

	public void multY(float factor) {
		this.y *= factor;
	}

	public void add(Vector2 vector2) {
		this.x += vector2.x;
		this.y += vector2.y;
	}

	public static Vector2 add(Vector2 vec1, Vector2 vec2) {
		return new Vector2(vec1.x + vec2.x, vec1.y + vec2.y);
	}

	public void sub(Vector2 vector2) {
		this.x -= vector2.x;
		this.y -= vector2.y;
	}

	public static Vector2 sub(Vector2 vec1, Vector2 vec2) {
		return new Vector2(vec1.x - vec2.x, vec1.y - vec2.y);
	}

	public void limit(float limit) {
		float length = calculateDistance(new Vector2(0, 0));
		if (length > limit) {
			this.x /= length;
			this.y /= length;
			this.x *= limit;
			this.y *= limit;
		}
	}

	public static Vector2 limit(Vector2 vec, float limit) {
		float length = vec.calculateDistance(new Vector2(0, 0));
		Vector2 result = new Vector2(vec);
		if (length > limit) {
			result.x /= length;
			result.y /= length;
			result.x *= limit;
			result.y *= limit;
		}
		return result;
	}

	public float calculateDistance(Vector2 vec) {
		return (float) Math.sqrt((vec.x - this.x)*(vec.x- this.x) + (vec.y- this.y)*(vec.y- this.y));
	}

	public void mult(float factor) {
		this.x *= factor;
		this.y *= factor;
	}

	public void div(float divisor) {
		this.x /= divisor;
		this.y /= divisor;
	}
}
