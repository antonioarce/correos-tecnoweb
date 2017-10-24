/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.presentador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thedath Oudarya
 */
public class Tablero {
    
    protected boolean showBlockIndex;

    protected int boardWidth;

    private Bloque initialBlock;

    private List<Letra> charrs;

    private String preview;

    public static final int APPEND_RIGHT = 16;

    public static final int APPEND_BELOW = 17;

    public Tablero(int boardWidth) {
        this.boardWidth = boardWidth;
        this.charrs = new ArrayList<>();
        this.preview = "";
        this.showBlockIndex = false;
        Bloque.nextIndex = 0;
    }

    public Tablero setInitialBlock(Bloque initialBlock) {
        this.initialBlock = initialBlock;
        return this;
    }

    public boolean isBlockIndexShowing() {
        return showBlockIndex;
    }

    public void showBlockIndex(boolean showBlockIndex) {
        this.showBlockIndex = showBlockIndex;
    }        

    public Tablero appendTableTo(int appendableBlockIndex, int appendableDirection, Tabla table) {
        Bloque tableBlock = table.tableToBlocks();
        Bloque block = getBlock(appendableBlockIndex);
        if (appendableDirection == APPEND_RIGHT) {
            block.setRightBlock(tableBlock);
            rearranegCoordinates(block);
        } else if (appendableDirection == APPEND_BELOW) {
            block.setBelowBlock(tableBlock);
            rearranegCoordinates(block);
        } else {
            throw new RuntimeException("Invalid block appending direction given");
        }
        return this;
    }

    private void rearranegCoordinates(Bloque block) {
        Bloque rightBlock = block.getRightBlock();
        Bloque belowBlock = block.getBelowBlock();
        if (rightBlock != null && belowBlock == null) {
            block.setRightBlock(rightBlock);
            rearranegCoordinates(rightBlock);
        } else if (rightBlock == null && belowBlock != null) {
            block.setBelowBlock(belowBlock);
            rearranegCoordinates(belowBlock);
        } else if (rightBlock != null && belowBlock != null) {
            int rightIndex = rightBlock.getIndex();
            int belowIndex = belowBlock.getIndex();
            int blockIdDiff = rightIndex - belowIndex;
            if (blockIdDiff > 0) {
                if (blockIdDiff == 1) {
                    block.setRightBlock(rightBlock);
                    block.setBelowBlock(belowBlock);
                    rearranegCoordinates(rightBlock);
                    rearranegCoordinates(belowBlock);
                } else {
                    block.setRightBlock(rightBlock);
                    rearranegCoordinates(rightBlock);
                    block.setBelowBlock(belowBlock);
                    rearranegCoordinates(belowBlock);
                }
            } else if (blockIdDiff < 0) {
                blockIdDiff *= -1;
                if (blockIdDiff == 1) {
                    block.setBelowBlock(belowBlock);
                    block.setRightBlock(rightBlock);
                    rearranegCoordinates(belowBlock);
                    rearranegCoordinates(rightBlock);
                } else {
                    block.setBelowBlock(belowBlock);
                    rearranegCoordinates(belowBlock);
                    block.setRightBlock(rightBlock);
                    rearranegCoordinates(rightBlock);
                }
            }
        }
    }

    public Bloque getBlock(int blockIndex) {
        if (blockIndex >= 0) {
            return getBlock(blockIndex, initialBlock);
        } else {
            throw new RuntimeException("Block index cannot be negative. " + blockIndex + " given.");
        }
    }

    private Bloque getBlock(int blockIndex, Bloque block) {
        Bloque foundBlock = null;
        if (block.getIndex() == blockIndex) {
            return block;
        } else {
            if (block.getRightBlock() != null) {
                foundBlock = getBlock(blockIndex, block.getRightBlock());
            }
            if (foundBlock != null) {
                return foundBlock;
            }
            if (block.getBelowBlock() != null) {
                foundBlock = getBlock(blockIndex, block.getBelowBlock());
            }
            if (foundBlock != null) {
                return foundBlock;
            }
        }
        return foundBlock;
    }

    public Tablero build() {
        if (charrs.isEmpty()) {
            //rearranegCoordinates(initialBlock);
            buildBlock(initialBlock);
            dumpCharrsFromBlock(initialBlock);

            int maxY = -1;
            int maxX = -1;
            for (Letra charr : charrs) {
                int testY = charr.getY();
                int testX = charr.getX();
                if (maxY < testY) {
                    maxY = testY;
                }
                if (maxX < testX) {
                    maxX = testX;
                }
            }
            String[][] dataPoints = new String[maxY + 1][boardWidth];
            for (Letra charr : charrs) {
                String currentValue = dataPoints[charr.getY()][charr.getX()];
                String newValue = String.valueOf(charr.getC());
                if (currentValue == null || !currentValue.equals("+")) {
                    dataPoints[charr.getY()][charr.getX()] = newValue;
                }
            }

            for (String[] dataPoint : dataPoints) {
                for (String point : dataPoint) {
                    if (point == null) {
                        point = String.valueOf(Letra.S);
                    }
                    preview = preview.concat(point);
                }
                preview = preview.concat(String.valueOf(Letra.NL));
            }
        }

        return this;
    }

    public String getPreview() {
        build();
        return preview;
    }

    public Tablero invalidate() {
        invalidateBlock(initialBlock);
        charrs = new ArrayList<>();
        preview = "";
        return this;
    }

    private void buildBlock(Bloque block) {
        if (block != null) {
            block.build();
            buildBlock(block.getRightBlock());
            buildBlock(block.getBelowBlock());
        }
    }

    private void dumpCharrsFromBlock(Bloque block) {
        if (block != null) {
            charrs.addAll(block.getChars());
            dumpCharrsFromBlock(block.getRightBlock());
            dumpCharrsFromBlock(block.getBelowBlock());
        }
    }

    private void invalidateBlock(Bloque block) {
        if (block != null) {
            block.invalidate();
            invalidateBlock(block.getRightBlock());
            invalidateBlock(block.getBelowBlock());
        }
    }

}
