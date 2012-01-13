package mockito;

import static org.mockito.Mockito.*;
public class MonthlyPayDAOMock {
	MonthlyPayDao daoMock ;
	
	public MonthlyPayDAOMock(){
		daoMock = mock(MonthlyPayDao.class);
	}
	
	public void setPay(String empId, long pay){
		if(pay>0){
			when(daoMock.getPay(empId)).thenReturn(pay);
		} else{
			when(daoMock.getPay(empId)).thenThrow(new RuntimeException("Low employee."));
		}
		
	}
	
	public long getPay(String empId){
		return daoMock.getPay(empId);
	}
	

}
