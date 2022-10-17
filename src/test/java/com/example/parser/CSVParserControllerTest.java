package com.example.parser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CSVParserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testEchoEmptyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/emptyFile.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/echo").file(file))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEchoNumbersOnlyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/numbers.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/echo").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void testInvertNumbersOnlyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/numbers.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/invert").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void testFlattenNumbersOnlyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/numbers.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/flatten").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void testSumNumbersOnlyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/numbers.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/sum").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void testSumNumbersAndStringsFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/numbersAndStrings.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/sum").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void testSumStringsOnlyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/text.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/sum").file(file))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testmultiplyNumbersOnlyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/numbers.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/multiply").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void testMultiplyNumbersAndStringsFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/numbersAndStrings.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/multiply").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void testMultiplyStringsOnlyFile() throws Exception {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/text.csv"));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                content
        );
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/multiply").file(file))
                .andExpect(status().isBadRequest());
    }
}