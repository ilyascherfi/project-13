package com.openclassrooms.ycyw.controller;

import com.openclassrooms.ycyw.model.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

  private final Map<String, Chat> chatSessions = new HashMap<>();

  /** Démarre une nouvelle session de chat pour un utilisateur */
  @PostMapping("/start")
  public ResponseEntity<Map<String, String>> newChat(@RequestBody String fullName) {
    String sessionId = UUID.randomUUID().toString(); // Générer un ID unique
    Chat session = new Chat(fullName);

    chatSessions.put(sessionId, session); // Associer l'ID à la session
    Map<String, String> response = new HashMap<>();
    response.put("sessionId", sessionId);
    return ResponseEntity.ok(response);
  }

}

