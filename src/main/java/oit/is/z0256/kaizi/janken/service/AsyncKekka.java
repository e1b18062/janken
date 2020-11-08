package oit.is.z0256.kaizi.janken.service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0256.kaizi.janken.model.Match;
import oit.is.z0256.kaizi.janken.model.MatchMapper;

@Service
public class AsyncKekka{

   private final Logger logger = LoggerFactory.getLogger(AsyncShopService57.class);

   @Autowired
   MatchMapper mMapper;

   @Async
   public void asyncShowmatch(SseEmitter emitter ){
     boolean is_active = true;
        try{
        while (true) {
        TimeUnit.MILLISECONDS.sleep(10);
        if (false == is_active) {
          continue;
        }
        
       }
     } catch (Exception e) {
      // 例外の名前とメッセージだけ表示する
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
    System.out.println("asyncShowFruitsList complete");
    }
  }
