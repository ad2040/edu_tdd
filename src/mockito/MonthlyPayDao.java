package mockito;

public interface MonthlyPayDao {
	public long getPay(String empId);
	public void setPay(String empId, long pay);

}
