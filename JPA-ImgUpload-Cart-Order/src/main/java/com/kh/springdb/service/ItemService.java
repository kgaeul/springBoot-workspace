package com.kh.springdb.service;

import com.kh.springdb.model.vo.CartItem;
import com.kh.springdb.model.vo.Item;
import com.kh.springdb.repository.ItemRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    // 상품 등록
    public void saveItem(Item item, MultipartFile imgFile) throws Exception {

        String oriImgName = imgFile.getOriginalFilename();
        String imgName = "";

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

       
        String savedFileName = "_" + oriImgName; // 파일명 -> imgName

        imgName = savedFileName;

        File saveFile = new File(projectPath, imgName);
        imgFile.transferTo(saveFile);
        item.setImgName(imgName);
        item.setImgPath("/files/" + imgName);
        itemRepository.save(item);
    }

    // 상품 개별 불러오기
    public Item itemView(Integer id) {
        return itemRepository.findById(id).get();
    }

    // 상품 리스트 불러오기
    public List<Item> allItemView() {
        return itemRepository.findAll();
    }

    // 상품 리스트 페이지용 불러오기
    public Page<Item> allItemViewPage(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    // 상품 수정
    @Transactional
    public void itemModify(Item item, Integer id, MultipartFile imgFile) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";
      
        String fileName = "_" + imgFile.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        imgFile.transferTo(saveFile);

        Item update = itemRepository.findItemById(id);
        update.setName(item.getName());
        update.setText(item.getText());
        update.setPrice(item.getPrice());
        update.setStock(item.getStock());
        update.setIsSoldout(item.getIsSoldout());
        update.setImgName(fileName);
        update.setImgPath("/files/"+fileName);
        itemRepository.save(update);
    }


    // 상품 검색
    public Page<Item> itemSearchList(String searchKeyword, Pageable pageable) {

        return itemRepository.findByNameContaining(searchKeyword, pageable);
    }

}

