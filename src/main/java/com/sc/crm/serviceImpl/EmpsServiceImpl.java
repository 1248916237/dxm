package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Dept;
import com.sc.crm.bean.Emps;
import com.sc.crm.bean.User;
import com.sc.crm.dao.ClientMapper;
import com.sc.crm.dao.DeptMapper;
import com.sc.crm.dao.EmpsMapper;
import com.sc.crm.dao.HouseMapper;
import com.sc.crm.dao.OrderMapper;
import com.sc.crm.dao.ProductMapper;
import com.sc.crm.dao.PurchaseMapper;
import com.sc.crm.dao.SupplierMapper;
import com.sc.crm.dao.UserMapper;
import com.sc.crm.service.EmpsService;

@Service("empsService")
public class EmpsServiceImpl implements EmpsService{

	@Resource
    private SqlSessionTemplate st;
	
	@Override
	public Emps selByUserId(Integer userId) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		Emps selByUserId = mapper.selByUserId(userId);
		return selByUserId;
	}

	@Override
	public void updateImg(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		mapper.updateByPrimaryKeySelective(emps);
	}

	@Override
	public List<Emps> getEmpsList(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		List<Emps> empsList = mapper.getEmpsList(emps);
		return empsList;
	}

	@Override
	public List<Dept> getDeptList() {
		DeptMapper mapper = st.getMapper(DeptMapper.class);
		List<Dept> deptList = mapper.getDeptList();
		return deptList;
	}

	@Override
	public int updateEmps(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		int i = mapper.updateByPrimaryKeySelective(emps);
		return i;
	}

	@Override
	public int addEmps(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		int i = mapper.insertSelective(emps);
		return i;
	}

	@Override
	public int delUser(User user) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		int i = mapper.updateByPrimaryKeySelective(user);
		return i;
	}

	@Override
	public int updatePass(User user) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		int i = mapper.updateByPrimaryKeySelective(user);
		return i;
	}

	@Override
	public int selCliNum() {
		ClientMapper mapper = st.getMapper(ClientMapper.class);
		int selCliNum = mapper.selCliNum();
		return selCliNum;
	}

	@Override
	public int selCliLossNum() {
		ClientMapper mapper = st.getMapper(ClientMapper.class);
		int selCliLossNum = mapper.selCliLossNum();
		return selCliLossNum;
	}

	@Override
	public Integer selOrderNum() {
		OrderMapper mapper = st.getMapper(OrderMapper.class);
		Integer selOrderNum = mapper.selOrderNum();
		return selOrderNum;
	}

	@Override
	public Integer selWaitPurNum() {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		Integer selWaitPurNum = mapper.selWaitPurNum();
		return selWaitPurNum;
	}

	@Override
	public Integer selSupplierNum() {
		SupplierMapper mapper = st.getMapper(SupplierMapper.class);
		Integer selSupplierNum = mapper.selSupplierNum();
		return selSupplierNum;
	}

	@Override
	public Integer selHouseNum() {
		HouseMapper mapper = st.getMapper(HouseMapper.class);
		Integer selHouseNum = mapper.selHouseNum();
		return selHouseNum;
	}

	@Override
	public Integer selUserNum() {
		UserMapper mapper = st.getMapper(UserMapper.class);
		Integer selUserNum = mapper.selUserNum();
		return selUserNum;
	}

	@Override
	public Integer selProductNum() {
		ProductMapper mapper = st.getMapper(ProductMapper.class);
		Integer selProductNum = mapper.selProductNum();
		return selProductNum;
	}

}
