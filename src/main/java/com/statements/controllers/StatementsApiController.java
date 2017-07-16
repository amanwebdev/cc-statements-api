package com.statements.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.statements.Constants.Education;
import com.statements.Constants.MaritalStatus;
import com.statements.json.TrendData;
import com.statements.models.CcHolder;
import com.statements.models.CcHolderDao;

@Controller
public class StatementsApiController {

	@RequestMapping("/api")
	@ResponseBody
	public String index() {
		return "CC Statements API";
	}

	@RequestMapping("/api/holders")
	@ResponseBody
	public Page<CcHolder> findAll(int page, int limit) {
		try {
			return ccHolderDao.findAll(new PageRequest(page, limit));
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping("/api/defaulters")
	@ResponseBody
	public Page<CcHolder> defaulters(int delayValue, int page, int limit) {
		try {
			return ccHolderDao.findByRepaySepGreaterThanOrderById(delayValue, new PageRequest(page, limit));
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/api/holders", params = "nameLike")
	@ResponseBody
	public Page<CcHolder> findHolders(@RequestParam String nameLike, int page, int limit) {
		try {
			return ccHolderDao.findByNameLikeIgnoreCase("%" + nameLike + "%", new PageRequest(page, limit));
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/api/holders", params = "idLike")
	@ResponseBody
	public String findHolders(Model model, @RequestParam Long idLike, Long page, Long limit) {
		try {
			List<CcHolder> holders = ccHolderDao.findAllFor("%" + idLike + "%", (page) * limit, page + 1 * limit);
			return "{\"content\":" + new ObjectMapper().writeValueAsString(holders) + "}";
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/api/maritalTrend")
	@ResponseBody
	public TrendData findMaritalTrend() {
		try {
			TrendData trend = new TrendData();

			String[] data = ccHolderDao.findPaymentsSum(MaritalStatus.MARRIED.getValue()).split(",");
			String[] singleData = ccHolderDao.findPaymentsSum(MaritalStatus.MARRIED.getValue()).split(",");

			trend.addSeries(MaritalStatus.MARRIED.toString(), strArrToInt(data));
			trend.addSeries(MaritalStatus.SINGLE.toString(), strArrToInt(singleData));

			return trend;
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/api/educationTrend")
	@ResponseBody
	public TrendData findEducationTrend() {
		try {
			TrendData trend = new TrendData();

			String[] data = ccHolderDao.findPaymentsEducationSum(Education.UNIVERSITY.getValue()).split(",");
			String[] gradSchoolData = ccHolderDao.findPaymentsEducationSum(Education.GRAD_SCHOOL.getValue()).split(",");
			String[] highSchoolData = ccHolderDao.findPaymentsEducationSum(Education.HIGH_SCHOOL.getValue()).split(",");
			String[] otherData = ccHolderDao.findPaymentsEducationSum(Education.OTHER.getValue()).split(",");

			trend.addSeries(Education.UNIVERSITY.toString(), strArrToInt(data));
			trend.addSeries(Education.GRAD_SCHOOL.toString(), strArrToInt(gradSchoolData));
			trend.addSeries(Education.HIGH_SCHOOL.toString(), strArrToInt(highSchoolData));
			trend.addSeries(Education.OTHER.toString(), strArrToInt(otherData));

			return trend;
		} catch (Exception ex) {
			return null;
		}
	}

	private Integer[] strArrToInt(String[] arr) {
		return Stream.of(arr).map(i -> {
			return Integer.valueOf(i);
		}).toArray(Integer[]::new);
	}

	@RequestMapping(value = "/api/ageTrend")
	@ResponseBody
	public TrendData findAgeTrend() {
		try {
			TrendData trend = new TrendData();
			
			List<Object[]> data = ccHolderDao.findPaymentsAgeSum();
			List<Integer[]> sepData = new ArrayList<Integer[]>();
			List<Integer[]> augData = new ArrayList<Integer[]>();
			List<Integer[]> julData = new ArrayList<Integer[]>();
			List<Integer[]> junData = new ArrayList<Integer[]>();
			List<Integer[]> mayData = new ArrayList<Integer[]>();
			List<Integer[]> aprilData = new ArrayList<Integer[]>();

			data.forEach(r -> {
				
				sepData.add(new Integer[]{Integer.parseInt(r[0].toString()), Integer.parseInt(r[1].toString()) });
				augData.add(new Integer[]{Integer.parseInt(r[0].toString()), Integer.parseInt(r[2].toString()) });
				julData.add(new Integer[]{Integer.parseInt(r[0].toString()), Integer.parseInt(r[3].toString()) });
				junData.add(new Integer[]{Integer.parseInt(r[0].toString()), Integer.parseInt(r[4].toString()) });
				mayData.add(new Integer[]{Integer.parseInt(r[0].toString()), Integer.parseInt(r[5].toString()) });
				aprilData.add(new Integer[]{Integer.parseInt(r[0].toString()), Integer.parseInt(r[6].toString()) });
			});
			

			trend.addLineSeries("September", sepData.toArray(new Object[] {}));
			trend.addLineSeries("August", augData.toArray(new Object[] {}));
			trend.addLineSeries("July", julData.toArray(new Object[] {}));
			trend.addLineSeries("June", junData.toArray(new Object[] {}));
			trend.addLineSeries("May", mayData.toArray(new Object[] {}));
			trend.addLineSeries("April", aprilData.toArray(new Object[] {}));
			

			return trend;
		} catch (Exception ex) {
			return null;
		}
	}

	@Autowired
	private CcHolderDao ccHolderDao;

}
