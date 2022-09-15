package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RowModel;
import com.example.demo.model.specializeListModel;
import com.example.demo.model.specializeMajorModel;
import com.example.demo.model.specializeMinorModel;
import com.example.demo.model.input.SpacializeMajorInputModel;
import com.example.demo.model.input.SpecializeListInputModel;
import com.example.demo.model.input.SpecializeMinorInputModel;

@Service
public class SpecializeService {

	public specializeListModel convert(SpecializeListInputModel json) {
		specializeListModel output = new specializeListModel();
		List<specializeMajorModel> arrmajorOutput = new ArrayList<>();
		int index = 0;
		for (SpacializeMajorInputModel i : json.getUserIoSpecializes()) {
			if (i.getRegIoSpecializeMinors().size() > 0) {
				specializeMajorModel majorOutput = new specializeMajorModel();
				majorOutput.setSpecializeMajorId((long) (index + 1));
				majorOutput.setSpecializeMajorName(i.getSpecializeMajorName());
				List<specializeMinorModel> minorModelList = new ArrayList<>();
				List<RowModel> rowModelList = new ArrayList<>();
				Integer count = 0;
				Integer countLoop = 0;
				for (SpecializeMinorInputModel item : i.getRegIoSpecializeMinors()) {

					RowModel rowModel = new RowModel();
					// Double num = Double.parseDouble(index+"."+countLoop);
					rowModel.setSpecializeMinorId((index + 1) + "." + (countLoop + 1));
					rowModel.setSpecializeMinorName(item.getSpecializeMinorName());
					rowModel.setSpecializeMinorSeq(item.getSpecializeMinorSeq());
					rowModelList.add(rowModel);
					count++;
					if (count == 3) {
						specializeMinorModel minorModel = new specializeMinorModel();
						minorModel.setRow(rowModelList);
						minorModelList.add(minorModel);
						rowModelList = new ArrayList<>();
						count = 0;
					}
					if (countLoop == i.getRegIoSpecializeMinors().size() - 1 && count != 0) {
						specializeMinorModel minorModel = new specializeMinorModel();
						minorModel.setRow(rowModelList);
						minorModelList.add(minorModel);
					}
					countLoop++;
				}
				majorOutput.setSpecializeMinor(minorModelList);
				arrmajorOutput.add(majorOutput);

				index++;
			}
		}
		output.setSpecializeMajor(arrmajorOutput);
		return output;
	}
}

